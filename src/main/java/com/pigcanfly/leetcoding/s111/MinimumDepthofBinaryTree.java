package com.pigcanfly.leetcoding.s111;

import java.util.ArrayList;

/**
 * @author tobbyquinn
 * @date 2019/11/11
 */
public class MinimumDepthofBinaryTree {

    public int minDepth1(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;

    }
    public int minDepth(TreeNode root) {
       if(root==null){
           return 0;
       }
        ArrayList<Integer> arr = new ArrayList<>();
        minDepth(root,arr,1);
        return arr.stream().mapToInt(Integer::intValue).min().getAsInt();
    }
    public void minDepth(TreeNode root,ArrayList<Integer> arr,int depth) {
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            arr.add(depth);
            return;
        }
        minDepth(root.left,arr,depth+1);
        minDepth(root.right,arr,depth+1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}