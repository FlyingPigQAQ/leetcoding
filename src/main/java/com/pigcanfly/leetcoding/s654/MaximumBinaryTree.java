package com.pigcanfly.leetcoding.s654;

/**
 * @author tobbyquinn
 * @date 2019/10/12
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree1(int[] nums) {
        if (nums.length == 0) {
            return new TreeNode(nums[0]);
        }
        int max = nums[0], maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        constructMaximumBinaryTree1(nums, 0, maxIndex - 1, root, true);
        constructMaximumBinaryTree1(nums, maxIndex + 1, nums.length - 1, root, false);
        return root;

    }

    public void constructMaximumBinaryTree1(int[] nums, int left, int right, TreeNode parent, boolean isLeft) {
        if (left > right) {
            return;
        }
        int max = nums[left], maxIndex = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        if (isLeft) {
            parent.left = root;
        } else {
            parent.right = root;
        }
        constructMaximumBinaryTree1(nums, left, maxIndex - 1, root, true);
        constructMaximumBinaryTree1(nums, maxIndex + 1, right, root, false);
    }


    //精简
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return new TreeNode(nums[0]);
        }
        return constructMaximumBinaryTree(nums,0,nums.length-1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int maxIndex = max(nums, left, right);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left=constructMaximumBinaryTree(nums, left, maxIndex - 1);
        root.right=constructMaximumBinaryTree(nums, maxIndex + 1, right);
        return root;
    }

    public int max(int[] nums, int left, int right) {
        int max = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        new MaximumBinaryTree().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
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
