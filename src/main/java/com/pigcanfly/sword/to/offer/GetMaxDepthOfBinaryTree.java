package com.pigcanfly.sword.to.offer;

/**
 * 求二叉树的最大高度
 *
 * @author tobbyquinn
 * @date 2019/09/26
 */
public class GetMaxDepthOfBinaryTree {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
