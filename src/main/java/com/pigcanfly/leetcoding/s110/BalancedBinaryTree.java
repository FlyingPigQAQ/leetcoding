package com.pigcanfly.leetcoding.s110;

/**
 * 空对象也是平衡二叉树。。
 *
 * @author tobbyquinn
 * @date 2020/02/06
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return isBalanced(root, 1) != -1;
    }

    public int isBalanced(TreeNode root, int height) {
        if (root == null) {
            return height - 1;
        }
        int left = isBalanced(root.left, height + 1);
        //TODO: 如果左子树已经为-1了 可以直接return，不需要判断右子树节点了
        int right = isBalanced(root.right, height + 1);
        int diff = Math.abs(left - right);
        if (diff <= 1 && left != -1 && right != -1) {
            return Math.max(left, right);
        } else {
            return -1;
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
