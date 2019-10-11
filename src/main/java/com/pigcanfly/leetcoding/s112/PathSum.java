package com.pigcanfly.leetcoding.s112;

/**
 * @author tobbyquinn
 * @date 2019/10/09
 */
public class PathSum {

    /**
     * 精简版代码 Nice
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.right == null && root.left == null && sum - root.val == 0) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }

    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return pathSum(root, 0, sum, false);

    }

    public boolean pathSum(TreeNode root, int sum, int target, boolean isleaf) {

        boolean b = false, c = false;
        isleaf = (root.left == null && root.right == null);
        if (root.left != null) {
            b = pathSum(root.left, sum + root.val, target, isleaf);
        } else {
            if (isleaf) {
                b = target == sum + root.val;
            }
        }
        if (root.right != null) {
            c = pathSum(root.right, sum + root.val, target, isleaf);
        } else {
            if (isleaf) {
                c = target == sum + root.val;
            }
        }
        return b || c;

    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.left = t2;
        boolean b = new PathSum().hasPathSum(t1, 1);
        System.out.println(b);

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
