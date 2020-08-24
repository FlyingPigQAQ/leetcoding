package com.pigcanfly.rpc.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.handler.stream.ChunkedWriteHandler;

import java.time.LocalDateTime;

/**
 * @author tobbyquinn
 * @date 2020/05/02
 */
public class WebsocketByNetty {
    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workGroup = new NioEventLoopGroup(1);
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                                    .addLast("http-codec", new HttpServerCodec())
                                    .addLast("aggregator", new HttpObjectAggregator(65536))
                                    .addLast("http-chunked", new ChunkedWriteHandler())
                                    .addLast(new WebsocketHandler());
                        }
                    });
            ChannelFuture f = b.bind(9090).sync();

            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

}

class WebsocketHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("kaishi");
        if (msg instanceof FullHttpRequest) {
            System.out.println("Full request");
            handleHttpRequest(ctx, (FullHttpRequest) msg);
        }
        if (msg instanceof WebSocketFrame) {
            System.out.println("web socket");
            handleWebSocket(ctx, (WebSocketFrame) msg);
        }

    }

    private void handleWebSocket(ChannelHandlerContext ctx, WebSocketFrame ws) {
        System.out.println(123);
        PingWebSocketFrame pingWebSocketFrame = new PingWebSocketFrame();
//        ByteBuf content = pingWebSocketFrame.content();
//        byte[] b = new byte[content.readableBytes()];
//        content.readBytes(b);

        PongWebSocketFrame pongWebSocketFrame = new PongWebSocketFrame();
        ByteBuf content1 = pongWebSocketFrame.content();
        byte[] b1 = new byte[content1.readableBytes()];
        content1.readBytes(b1);
        if (ws instanceof PingWebSocketFrame) {
            System.out.println("Server received client heartbeat message! "+LocalDateTime.now().toString());
            System.out.println("Server send  heartbeat message to client! "+LocalDateTime.now().toString());
            ctx.writeAndFlush(new PongWebSocketFrame());
        }
        if(ws instanceof BinaryWebSocketFrame){
            System.out.println("二进制");
        }
        if (ws instanceof TextWebSocketFrame) {
            System.out.println("textWeb");
            TextWebSocketFrame textWsF = new TextWebSocketFrame("Welcome to use WebSocket Server，Current Time:" + LocalDateTime.now().toString());
            ctx.write(textWsF);
        }
        ctx.write(pingWebSocketFrame.content().retain());


    }

    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) {
        WebSocketServerHandshaker webSocketServerHandshaker = new WebSocketServerHandshakerFactory("http://localhost:9090/wb", null, false)
                .newHandshaker(req);
        webSocketServerHandshaker.handshake(ctx.channel(), req);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("flush");
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
