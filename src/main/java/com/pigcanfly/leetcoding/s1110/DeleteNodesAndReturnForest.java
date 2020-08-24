package com.pigcanfly.leetcoding.s1110;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2020/01/10
 */
public class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> arr = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < to_delete.length; i++) {
            set.add(to_delete[i]);
        }
        delNodes(null, root, set, arr, true, false);
        return arr;
    }

    public void delNodes(TreeNode parent, TreeNode root, HashSet<Integer> set, List<TreeNode> arr, boolean isRoot, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (set.contains(root.val)) {
            delNodes(root, root.left, set, arr, true, true);
            delNodes(root, root.right, set, arr, true, false);
            if (parent != null) {
                if (isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        } else {
            if (isRoot) {
                arr.add(root);
            }
            delNodes(root, root.left, set, arr, false, true);
            delNodes(root, root.right, set, arr, false, false);
        }
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
