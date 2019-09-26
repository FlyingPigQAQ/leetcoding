package com.pigcanfly.leetcoding.s655;

import java.util.*;

/**
 * @author tobbyquinn
 * @date 2019/09/24
 */
public class PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
        ArrayList<List<String>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int treeHeight = getTreeHeight(1, root),max = (2 << (treeHeight-1)) - 1;
        Queue<TreeNode> dataQ = new LinkedList<>();
        Queue<int[]> indexQ = new LinkedList<>();
        dataQ.add(root);
        indexQ.add(new int[]{0, max - 1});
        int currentHeight=1;
        while (!dataQ.isEmpty()) {
            int len = dataQ.size();
            String[] arr = new String[max];
            Arrays.fill(arr, "");
            for (int i = 0; i < len; i++) {
                TreeNode data = dataQ.poll();
                int[] index = indexQ.poll();
                if (data == null) {
                    continue;
                }
                int left = index[0], right = index[1], mid = left + (right - left) / 2;
                arr[mid] = data.val + "";
                if (currentHeight < treeHeight) {
                    dataQ.add(data.left);
                    dataQ.add(data.right);
                    indexQ.add(new int[]{left, mid - 1});
                    indexQ.add(new int[]{mid + 1, right});
                }
            }
            if (currentHeight <= treeHeight) {
                currentHeight++;
                res.add(Arrays.asList(arr));
            }
        }
        return res;
    }


    public int getTreeHeight(int height, TreeNode root) {
        if (root == null) {
            return height - 1;
        }
        return Math.max(getTreeHeight(height + 1, root.left), getTreeHeight(height + 1, root.right));
    }

    public int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getTreeHeight(root.left), getTreeHeight(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode l1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);

        root.left = l1;
         new PrintBinaryTree().printTree(root);
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
