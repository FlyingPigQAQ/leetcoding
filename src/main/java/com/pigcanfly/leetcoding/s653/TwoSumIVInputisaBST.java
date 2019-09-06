package com.pigcanfly.leetcoding.s653;

import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/09/05
 */
public class TwoSumIVInputisaBST {
    private HashMap<Integer,Integer> map = new HashMap();
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        if(map.containsKey(k-root.val)){
            return true;
        }
        map.put(root.val,1);
        return findTarget(root.left,k) || findTarget(root.right,k);
    }

}
  class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }