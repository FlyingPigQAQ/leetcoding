package com.pigcanfly.rpc.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author tobbyquinn
 * @date 2020/04/14
 */
public class TimeClient {
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup workGroup = new NioEventLoopGroup(1);
        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workGroup);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new TimeClientHandler());

                }
            });

            ChannelFuture f = bootstrap.connect("localhost", 9090).sync();

            f.channel().closeFuture().sync();

        }finally {
            workGroup.shutdownGracefully();
        }
    }
}

class TimeClientHandler extends ChannelInboundHandlerAdapter{
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf m = (ByteBuf) msg;
        try{
            byte[] src = new byte[m.capacity()];
            m.getBytes(0,src);
            System.out.println(new String(src,"UTF-8"));
        }finally {
            m.release();
        }
    }
}
