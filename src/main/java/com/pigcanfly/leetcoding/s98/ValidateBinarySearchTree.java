package com.pigcanfly.leetcoding.s98;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO：递归
 * @author tobbyquinn
 * @date 2020/05/21
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inOrder(root,arr);
        for (int i = 1; i < arr.size(); i++) {
            if(arr.get(i)<=arr.get(i-1)){
                return false;
            }
        }
        return true;
    }

  private void inOrder(TreeNode root, List<Integer> arr){
        if(root==null){
            return;
        }
        inOrder(root.left,arr);
        arr.add(root.val);
        inOrder(root.right,arr);
  }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
