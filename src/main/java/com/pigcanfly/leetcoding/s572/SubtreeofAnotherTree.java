package com.pigcanfly.leetcoding.s572;

/**
 * @author tobbyquinn
 * @date 2019/12/06
 */
public class SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null){
            return false;
        }
        if(s.val==t.val){
            if(isSametree(s,t)){
                return true;
            }
        }
        return isSubtree(s.left,t)||isSubtree(s.right,t);
    }
    boolean isSametree(TreeNode s, TreeNode t) {
        if(s==null && t==null){
            return true;
        }else if(s==null || t==null){
            return false;
        }else if(s.val!=t.val){
            return false;
        }
        return isSametree(s.left,t.left) && isSametree(s.right,t.right);
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
