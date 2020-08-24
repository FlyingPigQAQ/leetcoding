package com.pigcanfly.leetcoding.s1469;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2020/06/05
 */
public class FindAlltheLonelyNodes {
    public List<Integer> getLonelyNodes(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        getLonelyNodes(root,res);
        return res;
    }

    private void getLonelyNodes(TreeNode root, ArrayList<Integer> arr) {
        if(root==null){
            return;
        }
        if(root.left!=null && root.right==null){
            arr.add(root.left.val);
        }
        if(root.left==null && root.right!=null){
            arr.add(root.right.val);
        }
        getLonelyNodes(root.left,arr);
        getLonelyNodes(root.right,arr);
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
