package com.pigcanfly.leetcoding.s669;

/**
 * @author Tobby Quinn
 * @date 2019/07/16
 */
public class TrimaBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null){
            return null;
        }

        root.left=trimBST(root.left,L,R);
        root.right=trimBST(root.right,L,R);
        if(root.val<L || R<root.val){
            root=root.left==null?root.right:root.left;
        }
        return root;

    }
    public TreeNode trimBST1(TreeNode root, int L, int R) {
        if (root == null) return null;

        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
