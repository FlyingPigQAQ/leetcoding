package com.pigcanfly.leetcoding.s513;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tobbyquinn
 * @date 2019/10/14
 */
public class FindBottomLeftTreeValue {
    /**
     * Left to Right BFS
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> sub = new LinkedList<>();
        q.add(root);
        int leftMost = 0;
        boolean isLeftMost = true;
        while (!q.isEmpty()) {
            TreeNode poll = q.poll();
            if (isLeftMost) {
                leftMost = poll.val;
                isLeftMost = false;
            }
            TreeNode left = poll.left;
            TreeNode right = poll.right;
            if (left != null) {
                sub.add(left);
            }
            if (right != null) {
                sub.add(right);
            }
            if (q.isEmpty()) {
                Queue<TreeNode> tmp = q;
                q = sub;
                sub = tmp;
                isLeftMost = true;
            }
        }
        return leftMost;
    }

    /**
     * Left to Right BFS
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            root = q.poll();
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (right != null) {
                q.add(right);
            }
            if (left != null) {
                q.add(left);
            }
        }
        return root.val;
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
