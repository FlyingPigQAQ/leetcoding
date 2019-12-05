package com.pigcanfly.leetcoding.s108;

/**
 * @author tobbyquinn
 * @date 2019/11/18
 */
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        return sortedArrayToBST(null,nums,0,nums.length-1);
    }

    public TreeNode sortedArrayToBST(TreeNode node,int[] nums,int left,int right) {
        if(left>right){
            return null;
        }
        int mid=left+(right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(root,nums,left,mid-1);
        root.right = sortedArrayToBST(root,nums,mid+1,right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new ConvertSortedArraytoBinarySearchTree().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(treeNode);
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
