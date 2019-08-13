package com.pigcanfly.leetcoding.s897;

/**
 * @author Tobby Quinn
 * @date 2019/08/07
 */
public class IncreasingOrderSearchTree {
    int[] res = new int[100];
    int index = 0;
    public TreeNode increasingBST(TreeNode root) {
        preOrder(root);
        TreeNode dummyHead = new TreeNode(-1);
        TreeNode head = dummyHead;
        for (int i = 0; i <index; i++) {
            head.right=new TreeNode(res[i]);
            head=head.right;
        }
        return dummyHead.right;

    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        res[index++] = root.val;
        preOrder(root.right);
    }

    TreeNode cur;
    public TreeNode increasingBST1(TreeNode root) {
        TreeNode dummyHead = new TreeNode(-1),cur=dummyHead;
        preOrder1(root);
        return dummyHead.right;

    }

    public void preOrder1(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder1(root.left);
        //只需要释放左子树链接即可
        root.left=null;
        cur.right=root;
        cur=root;
        preOrder1(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
