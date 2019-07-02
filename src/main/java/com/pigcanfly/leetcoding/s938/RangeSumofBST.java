package com.pigcanfly.leetcoding.s938;

/**
 * @author Tobby Quinn
 * @date 2019/06/29
 */
public class RangeSumofBST {
    private int sum=0;
    public int rangeSumBST(TreeNode root, int L, int R) {

        if(root==null){
            return 0;
        }
        if(L<=root.val && root.val<=R){
             sum+=root.val;
        }
        rangeSumBST(root.left,L,R);
        rangeSumBST(root.right,L,R);
        return sum;

    }


    /**
     * 代码优化
     * @param root
     * @param L
     * @param R
     * @return
     */
    public int rangeSumBST1(TreeNode root, int L, int R) {

        if(root==null){
            return 0;
        }
        return (L<=root.val && root.val<=R?root.val:0)
                +rangeSumBST1(root.left,L,R)+ rangeSumBST1(root.right,L,R);

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
