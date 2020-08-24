package com.pigcanfly.leetcoding.s437;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: 优化
 * 禁止arr.remove(arr.get(i))
 *
 * @author tobbyquinn
 * @date 2019/11/15
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        ArrayList<Integer> arr = new ArrayList<>();
        return pathSum(root, arr, sum, null,0);
    }

    private int pathSum(TreeNode root, List<Integer> arr, int sum, TreeNode parent,int height) {
        if (root == null) {
            return 0;
        }
        int size = arr.size();
        for (int i = size-height+1; i < size; i++) {
            arr.add(arr.get(i) + root.val);
        }
        if (parent != null) {
            arr.add(root.val + parent.val);
        }
        int left = pathSum(root.left, arr, sum, root,height+1);
        int right = pathSum(root.right, arr, sum, root,height+1);
        int current = root.val == sum ? 1 : 0;
        int len = arr.size();
        for (int i = len - 1; i >= len - 1-height+1; i--) {
            if (arr.get(i) == sum) {
                current += 1;
            }
            arr.remove(i);
        }
        return left + right + current;
    }

    public static void main(String[] args) {
        PathSumIII pathSumIII = new PathSumIII();
        TreeNode root = new TreeNode(10);
        TreeNode left1 = new TreeNode(5);
        TreeNode right1 = new TreeNode(-3);
        root.left = left1;
        root.right = right1;
        TreeNode left2 = new TreeNode(3);
        TreeNode right2 = new TreeNode(2);
        left1.left = left2;
        left1.right = right2;
        TreeNode left3 = new TreeNode(3);
        TreeNode right3 = new TreeNode(-2);
        left2.left = left3;
        left2.right = right3;

        TreeNode right4 = new TreeNode(1);
        right2.right = right4;


        System.out.println(pathSumIII.pathSum(root, 8));
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
