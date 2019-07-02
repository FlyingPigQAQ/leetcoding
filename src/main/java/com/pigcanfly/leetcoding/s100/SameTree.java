package com.pigcanfly.leetcoding.s100;

/**
 * @author Tobby Quinn
 * @date 2019/06/20
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        //此段代码可以精简
//        boolean sameTree = isSameTree(p.left, q.left);
//        if (!sameTree) {
//            return false;
//        }
//        boolean sameTree2 = isSameTree(p.right, q.right);
//        if (!sameTree2) {
//            return false;
//        }
//
//        return true;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        SameTree obj = new SameTree();
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        t2.left = null;
        t2.right = new TreeNode(2);
        obj.isSameTree(t1, t2);

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
