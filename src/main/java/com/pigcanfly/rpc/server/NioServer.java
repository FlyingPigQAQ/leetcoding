package com.pigcanfly.rpc.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tobbyquinn
 * @date 2020/07/27
 */
public class NioServer {

    private String host;
    private int port;
    private Selector selector = null;
    private Map<SocketChannel, ByteBuffer> memoryPool = new ConcurrentHashMap<SocketChannel, ByteBuffer>();

    public NioServer(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() {
        try {
            selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

            serverSocketChannel.bind(new InetSocketAddress(host, port), 501);
            //设置非阻塞模式
            serverSocketChannel.configureBlocking(false);

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                //就绪channel
                int readyChannels = selector.select(50);
                if (readyChannels == 0) {
                    continue;
                }
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> keysIter = keys.iterator();
                while (keysIter.hasNext()) {
                    SelectionKey key = keysIter.next();
                    if (!key.isValid()) {
                        continue;
                    }
                    if (key.isAcceptable()) {
                        acceptComplete(key);
                    } else if (key.isReadable()) {
                        readComplete(key);
                    } else if (key.isWritable()) {
                        //TODO write something
                    } else if (key.isConnectable()) {
                        //TODO XXX
                        System.out.println("连接发生改变");
                    }
                    //必须设置，避免事件被重新消费，selector只负责添加到该事件集合中，不负责删除
                    keysIter.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String host = "localhost";
        int port = 9090;
        final NioServer server = new NioServer(host, port);
        server.run();
    }

    private void readComplete(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        int readSize = 0;
        ByteBuffer byteBuffer = memoryPool.getOrDefault(socketChannel, ByteBuffer.allocate(1024));
        memoryPool.put(socketChannel, byteBuffer);
//        System.out.println(socketChannel);
        try {
            readSize = socketChannel.read(byteBuffer);
            while (byteBuffer.position() >= 6) {
                byteBuffer.flip();
                final byte[] bytes = new byte[6];
                byteBuffer.get(bytes);
                System.out.println(new String(bytes, StandardCharsets.UTF_8));
                byteBuffer.compact();
            }


        } catch (IOException ex) {
            System.out.println("客户端连接异常关闭");
            //释放内存
            byteBuffer = null;
            memoryPool.remove(socketChannel);
            socketChannel.close();
            selectionKey.cancel();
        }

//        if(readSize>0){
//            byteBuffer.flip();
//            final byte[] bytes = new byte[byteBuffer.limit()];
//            byteBuffer.get(bytes, 0, bytes.length);
//            System.out.println(new String(bytes, StandardCharsets.UTF_8));
//        }
        if (readSize == -1) {
            System.out.println("closed");
            byteBuffer = null;
            memoryPool.remove(socketChannel);
            selectionKey.cancel();
            socketChannel.close();
        }

    }

    private void acceptComplete(SelectionKey selectionKey) throws IOException {
        ServerSocketChannel serverSocket = (ServerSocketChannel) selectionKey.channel();
        SocketChannel socketChannel = serverSocket.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
    }
}
