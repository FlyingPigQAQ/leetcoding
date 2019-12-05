package com.pigcanfly.leetcoding.s437;

import java.util.ArrayList;

/**
 * @author tobbyquinn
 * @date 2019/11/15
 */
public class PathSumIII {
    int sum = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        //pathSum(root,sum,null);
        return 0;
    }

    public ArrayList<Integer> sumPath(TreeNode root, int sum) {
        if (root == null) {
            new ArrayList<Integer>();
        }
        ArrayList<Integer> left = sumPath(root.left, sum);
        ArrayList<Integer> right = sumPath(root.right, sum);
        //     arr.add(root.val);
        return null;
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
