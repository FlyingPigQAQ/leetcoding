package com.pigcanfly.leetcoding.s366;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2020/08/01
 */
public class FindLeavesofBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        while (root != null) {
            List<Integer> tmp = new ArrayList<>();
            findLeaves(null, root, tmp);
            res.add(tmp);
        }
        return res;
    }

    public void findLeaves(TreeNode parent, TreeNode current, List<Integer> arr) {
        if (current == null) {
            return;
        }
        if (current.left == null && current.right == null) {
            arr.add(current.val);
            current=null;
            return;
        }
        findLeaves(current, current.left, arr);
        findLeaves(current, current.right, arr);
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
