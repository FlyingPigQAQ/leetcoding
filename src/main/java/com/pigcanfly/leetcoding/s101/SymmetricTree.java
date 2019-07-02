package com.pigcanfly.leetcoding.s101;

/**
 * @author Tobby Quinn
 * @date 2019/06/20
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        //判断输入为null,或者仅有一个父节点
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        return isSymmetric(root.left, root.right);
    }


    public boolean isSymmetric(TreeNode lNode, TreeNode rNode) {
        //递归返回条件
        if(lNode==null && rNode==null){
            return true;
        }
        if(lNode==null || rNode==null){
            return false;
        }
        if(lNode.val!=rNode.val){
            return false;
        }
        return isSymmetric(lNode.left, rNode.right) && isSymmetric(lNode.right, rNode.left);
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
