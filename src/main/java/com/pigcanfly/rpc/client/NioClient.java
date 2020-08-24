package com.pigcanfly.rpc.client;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author tobbyquinn
 * @date 2020/07/27
 */
public class NioClient {
    private static final Charset UTF8 = StandardCharsets.UTF_8;
    public static void main(String[] args) {

        try (Socket remote = new Socket("localhost", 9090)) {
            Scanner sc = new Scanner(System.in);
            final OutputStream ous = remote.getOutputStream();
//            while (true) {
//                System.out.print("请输入:");
//                final String input = sc.next();
//                if("exit".equals(input)){
//                    break;
//                }
//                ous.write(input.getBytes(UTF8));
//            }
            for (int i = 0; i < 3000; i++) {
                ous.write("HelloW".getBytes(UTF8));
            }
            ous.flush();
            ous.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
