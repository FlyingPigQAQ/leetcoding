package com.pigcanfly.leetcoding.s1038;

/**
 * @author tobbyquinn
 * @date 2020/01/15
 */
public class BinarySearchTreetoGreaterSumTree {
    public TreeNode bstToGst(TreeNode root) {
        bstToGstModify(root,0);
        return root;
    }

    /**
     * 返回左子树最大值
     * @param root
     * @param maxVal
     * @return
     */
    public int  bstToGstModify(TreeNode root,int maxVal) {
        if(root==null){
            return maxVal;
        }
        int rightVal = bstToGstModify(root.right,maxVal);
        int leftVal=bstToGstModify(root.left,root.val+rightVal);
        root.val=leftVal;
        return leftVal;
    }

    /**
     * 另一种递归方式
     */
    int pre = 0;
    public TreeNode bstToGst1(TreeNode root) {
        if (root.right != null) {
            bstToGst1(root.right);
        }
        pre = root.val = pre + root.val;
        if (root.left != null) {
            bstToGst1(root.left);
        }
        return root;
    }
}
class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
