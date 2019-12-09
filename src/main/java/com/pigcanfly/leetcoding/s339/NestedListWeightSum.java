package com.pigcanfly.leetcoding.s339;

import java.util.List;

/**
 * @author tobbyquinn
 * @date 2019/12/09
 */
public class NestedListWeightSum {
    /**
     * 写法一
     * @param nestedList
     * @return
     */
    public int depthSum1(List<NestedInteger> nestedList) {
        int sum=0;
        for (NestedInteger nestedInteger : nestedList) {
            sum+=depthSum1(nestedInteger,1);
        }
        return sum;
    }
    int depthSum1(NestedInteger nestedInteger,int weight){
        if(nestedInteger.isInteger()){
            return nestedInteger.getInteger()*weight;
        }
        int sum=0;
        List<NestedInteger> list = nestedInteger.getList();
        for (int i = 0; i < list.size(); i++) {
            sum+=depthSum1(list.get(i),weight+1);
        }
        return sum;
    }

    /**
     * 写法二
     * @param nestedList
     * @return
     */
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList,1);
    }
    int depthSum(List<NestedInteger> nestedList ,int weight){
        int sum=0;
        for (NestedInteger nestedInteger : nestedList) {
            if(nestedInteger.isInteger()){
                sum+=nestedInteger.getInteger()*weight;
            }else{
                sum+=depthSum(nestedInteger.getList(),weight+1);
            }
        }
        return sum;
    }

}

class NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger(){};

    // Constructor initializes a single integer.
    public NestedInteger(int value){};

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger(){
        return false;
    };

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger(){
        return 0;
    };

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value){};

    /* Set this NestedInteger to hold a nested list and adds a nested integer to it. */
    public void add(NestedInteger ni){};

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList(){
        return null;
    };
}
