package com.pigcanfly.leetcoding.s1022;

import java.util.ArrayList;

/**
 * @author tobbyquinn
 * @date 2019/10/10
 */
public class SumofRootToLeafBinaryNumbers {
    public int sumRootToLeaf1(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        sumRootToLeaf1(root, 0, new int[512], arr);
        int res = 0;
        for (int i = 0; i < arr.size(); i++) {
            res += arr.get(i);
        }
        return res;
    }

    public void sumRootToLeaf1(TreeNode root, int index, int[] arrs, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        arrs[index] = root.val;
        if (root.left == null && root.right == null) {
            int num = 0;
            for (int i = index; i >= 0; i--) {
                num += arrs[i] * Math.pow(2, index - i);
            }
            arr.add(num);
        }
        sumRootToLeaf1(root.left, index + 1, arrs, arr);
        sumRootToLeaf1(root.right, index + 1, arrs, arr);
    }

    /**
     * Better
     * @param root
     * @return
     */
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root,0);
    }
    public int sumRootToLeaf(TreeNode root,int val) {
        if (root == null) {
            return 0;
        }
        val = val * 2 + root.val;
        return root.left == null && root.right == null ? val : sumRootToLeaf(root.left,val)+sumRootToLeaf(root.right,val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(0);
        TreeNode r1 = new TreeNode(1);
        root.left=l1;
        root.right=r1;

        TreeNode l2 = new TreeNode(0);
        TreeNode r2 = new TreeNode(1);
        l1.left=l2;
        l1.right=r2;

        TreeNode l3 = new TreeNode(0);
        TreeNode r3 = new TreeNode(1);
        r1.left=l3;
        r1.right=r3;
        new SumofRootToLeafBinaryNumbers().sumRootToLeaf(root);

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
