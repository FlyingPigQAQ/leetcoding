package com.pigcanfly.leetcoding.s868;

/**
 * @author tobbyquinn
 * @date 2019/11/23
 */
public class BinaryGap {
    public int binaryGap(int N) {
        int lastOneIndex = -1,maxDistance = 0;
        for (int i = 0; i < 31; i++) {
            if (((N >> i) & 1) == 1) {
                if (lastOneIndex != -1) {
                    maxDistance=Math.max(maxDistance, i - lastOneIndex);
                }
                lastOneIndex = i;
            }
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        int i = new BinaryGap().binaryGap(22);
        System.out.println(i);
    }
}
