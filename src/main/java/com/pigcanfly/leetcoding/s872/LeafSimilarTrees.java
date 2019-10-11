package com.pigcanfly.leetcoding.s872;

import java.util.ArrayList;

/**
 * @author tobbyquinn
 * @date 2019/10/10
 */
public class LeafSimilarTrees {
    ArrayList<Integer> arr1 = new ArrayList();
    ArrayList<Integer> arr2 = new ArrayList();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        iterTree(root1,arr1);
        iterTree(root2,arr2);
        if(arr1.size()!=arr2.size()){
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if(!arr1.get(i).equals(arr2.get(i))){
                return false;
            }
        }
        return true;
    }

    public void iterTree(TreeNode root,ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            arr.add(root.val);
        }
        iterTree(root.left,arr);
        iterTree(root.right,arr);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(44);
        TreeNode l1 = new TreeNode(79);
        TreeNode r1 = new TreeNode(25);
        root1.left=l1;
        root1.right=r1;

        TreeNode l2 = new TreeNode(112);
        TreeNode r2 = new TreeNode(7);
        r1.left=l2;
        r1.right=r2;

        TreeNode l3 = new TreeNode(74);
        TreeNode r3 = new TreeNode(49);
        l2.left=l3;
        l2.right=r3;

        TreeNode l4 = new TreeNode(2);
        TreeNode r4 = new TreeNode(122);
        r2.left=l4;
        r2.right=r4;

        //构造第二个树
        TreeNode root2 = new TreeNode(38);
        TreeNode l21 = new TreeNode(86);
        TreeNode r21 = new TreeNode(120);
        root2.left=l21;
        root2.right=r21;


        TreeNode l22 = new TreeNode(49);
        TreeNode r22 = new TreeNode(54);
        l21.left=l22;
        l21.right=r22;

        TreeNode l23 = new TreeNode(74);
        TreeNode r24 = new TreeNode(79);
        r22.left=l23;
        r22.right=r24;

        TreeNode l25 = new TreeNode(2);
        TreeNode r26 = new TreeNode(122);
        r21.left=l25;
        r21.right=r26;

        boolean b = new LeafSimilarTrees().leafSimilar(root1, root2);
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
