package com.pigcanfly.leetcoding.s617;

/**
 * @author Tobby Quinn
 * @date 2019/07/02
 */
public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root=null;
        if(t1==null  && t2==null){
            return null;
        }
        if(t1!=null || t2!=null){
            root = new TreeNode(0);
            root.val=(t1!=null&&t2!=null)?t1.val+t2.val:(t1!=null && t2==null)?t1.val:t2.val;
        }
        root.left=mergeTrees(t1==null?null:t1.left,t2==null?null:t2.left);
        root.right=mergeTrees(t1==null?null:t1.right,t2==null?null:t2.right);
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
