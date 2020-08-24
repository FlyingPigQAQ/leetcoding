package com.pigcanfly.leetcoding.s701;

/**
 * @author tobbyquinn
 * @date 2020/01/10
 */
public class InsertintoaBinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
       if(root==null ){
           return new TreeNode(val);
       }
        if(root.val<=val){
            root.right=insertIntoBST(root.right,val);
        }else {
            root.left=insertIntoBST(root.left,val);
        }
        return root;
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
