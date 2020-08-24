package com.pigcanfly.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

/**
 * @author tobbyquinn
 * @date 2020/02/27
 */
public class BigDataFile {
    public static void main(String[] args) {
        final long times=1073741824/2L;
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("/Users/tobbyquinn/Downloads/BigData.txt"))) {
            Random rd = new Random(Integer.MAX_VALUE);
            for (long i = 0; i < times; i++) {
                bufferedWriter.write(""+rd.nextInt(Integer.MAX_VALUE));
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
