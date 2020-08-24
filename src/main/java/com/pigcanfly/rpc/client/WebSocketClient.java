package com.pigcanfly.rpc.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.handler.stream.ChunkedWriteHandler;

import java.net.InetSocketAddress;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author tobbyquinn
 * @date 2020/05/04
 */
public class WebSocketClient {

    private static final int LOCAL_PORT = 46564;

    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup workGroup = new NioEventLoopGroup(1);
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workGroup);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline()
                            .addLast(new HttpClientCodec())
                            .addLast(new HttpObjectAggregator(65536))
                            .addLast(new WebSocketClientHandler(LOCAL_PORT));

                }
            });

            ChannelFuture f = bootstrap.connect(new InetSocketAddress("localhost", 9090), new InetSocketAddress(26666)).sync();

            f.channel().closeFuture().sync();

        } finally {
            workGroup.shutdownGracefully();
        }
    }
}

class WebSocketClientHandler extends ChannelInboundHandlerAdapter {
    private int localPort;

    private ChannelPromise channelPromise =null;
    private WebSocketClientHandshaker webSocketClientHandshaker = WebSocketClientHandshakerFactory
            .newHandshaker(URI.create("ws://localhost:9090/wb"), WebSocketVersion.V13, null, false, EmptyHttpHeaders.INSTANCE);

    public WebSocketClientHandler(int localPort) {
        this.localPort = localPort;
    }

    private class WebSocketHeartBeat implements Runnable {
        private ChannelHandlerContext ctx;

        public WebSocketHeartBeat(ChannelHandlerContext ctx) {
            this.ctx = ctx;
        }

        @Override
        public void run() {
            System.out.println("Client send server heartbeat! "+ LocalDateTime.now().toString());
            ctx.writeAndFlush(ping());
            //ctx.writeAndFlush(new PingWebSocketFrame());
        }
        private ByteBuf ping() {
            ByteBuf buffer = Unpooled.buffer(48);
            buffer.writeByte(0b10001001);
            //mask payload length
            buffer.writeByte(0b10000000);
            //mask-keying
            Random rd = new Random();
            buffer.writeInt(rd.nextInt());
            return buffer;
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        webSocketClientHandshaker.handshake(ctx.channel());
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
         channelPromise = ctx.newPromise();
    }

    private void handleHttpRequest(ChannelHandlerContext ctx) {
        DefaultFullHttpRequest req = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "http://localhost:9090/wb");
        req.headers().add("Connection", "Upgrade");
        req.headers().add("Upgrade", "websocket");
        req.headers().add("Origin", "http://localhost:" + localPort + "/");
        ctx.writeAndFlush(req);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        if (!webSocketClientHandshaker.isHandshakeComplete()) {
            webSocketClientHandshaker.finishHandshake(ctx.channel(), (FullHttpResponse) msg);
            channelPromise.setSuccess();
            ctx.executor().scheduleAtFixedRate(new WebSocketHeartBeat(ctx), 5, 5, TimeUnit.SECONDS);
            return;
        }
        if (msg instanceof PongWebSocketFrame) {
            System.out.println("Client receive server heartbeat! "+ LocalDateTime.now().toString());
        }
//        if (msg instanceof HttpResponse) {
//            DefaultHttpResponse resp = (DefaultHttpResponse) msg;
//            System.out.println(resp.status().code());
//            System.out.println(resp.status().reasonPhrase());
//            for (Map.Entry<String, String> header : resp.headers()) {
//                System.out.println(header.getKey() + ":" + header.getValue());
//            }
//        }

    }




    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }


}
