package com.pigcanfly.leetcoding.s530;

import java.util.ArrayList;

/**
 * @author tobbyquinn
 * @date 2019/11/11
 */
public class MinimumAbsoluteDifferenceinBST {
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        getMinimumDifference(root,arr);
        int ans=Integer.MAX_VALUE;
        for (int i = 1; i < arr.size(); i++) {
            int abs = Math.abs(arr.get(i) - arr.get(i - 1));
            if(abs==0){
                return 0;
            }
            ans=Math.min(ans,abs);
        }
        return ans;
    }
    public void getMinimumDifference(TreeNode root,ArrayList<Integer> arr) {
        if(root==null){
            return;
        }
        getMinimumDifference(root.left,arr);
        arr.add(root.val);
        getMinimumDifference(root.right,arr);
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
