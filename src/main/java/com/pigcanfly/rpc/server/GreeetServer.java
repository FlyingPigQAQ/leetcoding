package com.pigcanfly.rpc.server;

import com.pigcanfly.rpc.MyProtocol;
import com.pigcanfly.rpc.utils.ClassUtils;
import com.pigcanfly.rpc.utils.MetadataUtils;
import com.pigcanfly.rpc.utils.SerializationUtils;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tobbyquinn
 * @date 2020/04/15
 */
public class GreeetServer {


    public static void main(String[] args) throws InterruptedException {

        int port = 9999;
        new GreeetServer().run(port);
    }

    private void run(int port) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new GreetServerHandler());
                        }
                    });
            ChannelFuture f = b.bind(port).sync();
            f.channel().closeFuture().sync();
        } finally {
            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }
}

class GreetServerHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf m = (ByteBuf) msg;
        byte[] dest = new byte[m.readableBytes()];
        m.readBytes(dest);
        MyProtocol rpc = (MyProtocol) SerializationUtils.deSerialize(dest);
        //TODO: 改为单例
        String interFace = rpc.getInterfaceName();
        String methodName = rpc.getMethodName();

        ConcurrentHashMap<String, String> metadata = MetadataUtils.findAllClassesByPackage("com.pigcanfly.rpc");
        Iterator<Map.Entry<String, String>> iterator = metadata.entrySet().iterator();
        HashMap<String, List<String>> interfaceWithImplementations = new HashMap<>();
        while (iterator.hasNext()){
            String fullClassName = iterator.next().getValue();
            for (Class interfacesByClass : MetadataUtils.findInterfacesByClass(fullClassName)) {
                List<String> classes = interfaceWithImplementations.getOrDefault(interfacesByClass, new ArrayList<>());
                classes.add(fullClassName);
                interfaceWithImplementations.put(interfacesByClass.getName(), classes);
            }
        }
        List<String> implementations = interfaceWithImplementations.get(interFace);
        if(implementations==null || implementations.size()==0){
            throw new RuntimeException(String.format("找不到接口%s实现类",interFace));
        }
        //Find First
        String impl = implementations.get(0);
        Object o = ClassUtils.getClassLoader().loadClass(impl).newInstance();
        Class<?> aClass = ClassUtils.getClassLoader().loadClass(impl);
        String invoke =(String) aClass.getDeclaredMethod(methodName, String.class).invoke(o, rpc.getArgs());
        System.out.println(invoke);
        ByteBuf writeBuf = ctx.alloc().buffer(invoke.length());
        writeBuf.writeBytes(invoke.getBytes("UTF-8"));
        ChannelFuture f = ctx.writeAndFlush(writeBuf);
       // f.addListener(ChannelFutureListener.CLOSE);


    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}