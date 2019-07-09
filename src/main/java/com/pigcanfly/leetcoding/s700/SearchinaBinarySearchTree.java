package com.pigcanfly.leetcoding.s700;

/**
 * @author Tobby Quinn
 * @date 2019/07/03
 */
public class SearchinaBinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {

        if(root==null ){
            return null;
        }
        if(root.val==val){
            return root;
        }
        return val<root.val?searchBST(root.left,val):searchBST(root.right,val);
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
