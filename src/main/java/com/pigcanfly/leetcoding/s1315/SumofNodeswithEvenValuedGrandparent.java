package com.pigcanfly.leetcoding.s1315;

/**
 * @author tobbyquinn
 * @date 2020/01/13
 */
public class SumofNodeswithEvenValuedGrandparent {
    /**
     * 方法一
     */
    int total = 0;
    public int sumEvenGrandparent(TreeNode root) {
        sumEvenGrandparent(root, null, null);
        return total;
    }

    public void sumEvenGrandparent(TreeNode root, TreeNode grandParent, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (grandParent != null && grandParent.val % 2 == 0) {
            total += root.val;
        }
        sumEvenGrandparent(root.left, parent, root);
        sumEvenGrandparent(root.right, parent, root);
    }

    /**
     * 方法二
     * @param root
     * @return
     */
    public int sumEvenGrandparent1(TreeNode root) {
        return sumEvenGrandparent1(root, null, null);
    }
    public int sumEvenGrandparent1(TreeNode root, TreeNode grandParent, TreeNode parent) {
        if(root==null){
            return 0;
        }
        return sumEvenGrandparent1(root.left,parent,root)
                +sumEvenGrandparent1(root.right,parent,root)
                +(grandParent!=null && grandParent.val%2==0?root.val:0);
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
