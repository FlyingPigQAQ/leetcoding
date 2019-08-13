package com.pigcanfly.leetcoding.s1103;

/**
 * @author Tobby Quinn
 * @date 2019/08/07
 */
public class DistributeCandiestoPeople {
    public static int[] distributeCandies(int candies, int num_people) {
        int n = 1;
        while (true) {
            long much = ((1 + n) * n) / 2;
            if (much > candies) {
                n--;
                break;
            }
            n++;
        }
        long much1 = ((1 + n) * n) / 2;
        long remain =candies-much1;
        int[] res = new int[num_people];
        int mod = n % num_people ;
        for (int i = 0; i < num_people; i++) {
            long l;
            if(mod==0){
                l = ((n -num_people+1+i) + (i + 1)) * (n/num_people) / 2;
            }else if (i < mod) {
                l = ((n - mod + 1 + i) + (i + 1)) * (n/num_people+1) / 2;
            } else {
                l = ((n - mod - (num_people - 1 - i)) + (i + 1)) * (n/num_people) / 2;
            }
            res[i] = (int) l;
        }
        res[mod] += remain;
        return res;
    }

    public static void main(String[] args) {
        distributeCandies(80,4);
    }
}
