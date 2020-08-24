package com.pigcanfly.rpc.client;

import com.pigcanfly.rpc.MyProtocol;
import com.pigcanfly.rpc.utils.SerializationUtils;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author tobbyquinn
 * @date 2020/04/15
 */
public class GreetClient {
    public void run(String host, int port) throws InterruptedException {
        NioEventLoopGroup workGroup = new NioEventLoopGroup(1);
        try {
            Bootstrap b = new Bootstrap();
            b.group(workGroup);
            b.channel(NioSocketChannel.class);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new GreetHandler());
                }
            });

            ChannelFuture f = b.connect(host, port).sync();
            f.channel().closeFuture().sync();

        } finally {
            workGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        String host = "localhost";
        int port = 9999;
        try {
            new GreetClient().run(host, port);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class GreetHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //TODO：增加对重载函数支持
        MyProtocol rpc = new MyProtocol("com.pigcanfly.rpc.GreetService", "sayHello", new Object[]{"Netty"});
        byte[] serialize = SerializationUtils.serialize(rpc);
        ByteBuf b = null;
        ChannelFuture f =null;
        try {
            b=ctx.alloc().buffer(serialize.length);
            b.writeBytes(serialize);
             f = ctx.writeAndFlush(b);
        } finally {
//            f.addListener()
            //b.release();
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("进入");
        ByteBuf m = (ByteBuf) msg;
        byte[] bytes = new byte[m.readableBytes()];
        m.readBytes(bytes);
        System.out.println(new String(bytes, "UTF-8"));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}