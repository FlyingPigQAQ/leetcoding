package com.pigcanfly.sword.to.offer;

import java.util.HashMap;

/**
 * Description: 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 *             数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 *             请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 *             那么对应的输出是第一个重复的数字2。
 * @author tobbyquinn
 * @date 2019/09/26
 */
public class DumplicateDigitsInIntArray {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    /**
     方法1：先排序，再对比 时间复杂度 O(NlogN),空间复杂度 O(1)
     */
    public boolean duplicate1(int numbers[],int length,int [] duplication) {
        if(length==0){
            return false;
        }
        java.util.Arrays.sort(numbers);
        for(int i=1;i<length;i++){
            if(numbers[i-1]==numbers[i]){
                duplication[0]=numbers[i];
                return true;
            }
        }
        return false;
    }
    /**
     * 方法2：使用HashMap做过滤 时间复杂度 O(N) ,空间复杂度 O(N)
     */
    public boolean duplicate2(int numbers[],int length,int [] duplication) {
        if(length==0){
            return false;
        }
        HashMap<Integer, Integer> cache = new HashMap<>();
        for(int i=0;i<length;i++){
            int ni = numbers[i];
            if(cache.containsKey(ni)){
                duplication[0]=ni;
                return true;
            }
            cache.put(ni,1);
        }
        return false;
    }
    /**
     * 方法3: 使用数组下标比较，将数移动到对应的下标位置，如果有下标与其value相同，忽略
     *  如果要查询的位置的数的对应下标和该数相同，则表示有重复数据。 时间复杂度O(1),空间复杂度 O(1)
     */
    public boolean duplicate3(int numbers[],int length,int [] duplication) {
        if(length==0){
            return false;
        }
        for(int i=0;i<length;i++){
            int ni = numbers[i];
            if(i==ni){
                continue;
            }
            if(numbers[ni]==ni){
                duplication[0]=ni;
                return true;
            }
            numbers[i]=numbers[ni];
            numbers[ni]=ni;
            i--;
        }
        return false;
    }
}
