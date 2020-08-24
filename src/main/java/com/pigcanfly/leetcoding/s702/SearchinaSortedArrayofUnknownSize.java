package com.pigcanfly.leetcoding.s702;

/**
 * @author tobbyquinn
 * @date 2020/01/31
 */
public class SearchinaSortedArrayofUnknownSize {

    public int search(ArrayReader reader, int target) {
        final int exceed=2147483647;
        int leftIndex=0,rightIndex=2;
        int rightResult=reader.get(rightIndex);
        while (rightResult!=exceed && rightResult<target){
            rightIndex<<=1;
            rightResult=reader.get(rightIndex);
        }
        while (leftIndex<=rightIndex){
            int mid= leftIndex+((rightIndex-leftIndex)>>1);
            int result = reader.get(mid);
            if(result==target){
                return mid;
            }else if(result==exceed || result>target){
                rightIndex=mid-1;
            }else if(result<target){
                leftIndex=mid+1;
            }
        }
        return -1;
    }
}
interface ArrayReader{
    int get(int k);
}
