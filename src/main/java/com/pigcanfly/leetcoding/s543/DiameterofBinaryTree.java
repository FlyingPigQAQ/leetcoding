package com.pigcanfly.leetcoding.s543;

import java.util.ArrayList;
import java.util.OptionalInt;

/**
 * @author tobbyquinn
 * @date 2019/11/11
 */
public class DiameterofBinaryTree {
    public int diameterOfBinaryTree1(TreeNode root) {
        if(root==null){
            return 0;
        }
        int currentMaxAns = calculateMaxPath(root.left)  +calculateMaxPath(root.right);
        int leftMaxAns = diameterOfBinaryTree1(root.left);
        int rightMaxAns = diameterOfBinaryTree1(root.right);
        return Math.max(Math.max(rightMaxAns,leftMaxAns),currentMaxAns);
    }

    public int calculateMaxPath(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=calculateMaxPath(root.left);
        int right=calculateMaxPath(root.right);
        return (left==0 || right==0)?left+right+1:Math.max(left,right)+1;
    }

    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
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
