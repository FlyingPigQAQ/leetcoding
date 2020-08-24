package com.pigcanfly.leetcoding.s107;

import java.util.*;

/**
 * @author tobbyquinn
 * @date 2020/02/07
 */
public class BinaryTreeLevelOrderTraversalII {
    /**
     * BFS
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        if(root==null){
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()){
            ArrayList<Integer> arr = new ArrayList<>();
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                arr.add(poll.val);
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }
            }
            res.add(arr);
        }
        Collections.reverse(res);
        return res;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderBottom(res,root,1);
        Collections.reverse(res);
        return res;
    }
    public void levelOrderBottom(List<List<Integer>> arr,TreeNode root,int height) {
        if (root==null){
            return;
        }
        if(height>arr.size()){
            arr.add(new ArrayList<>());
        }
        arr.get(height-1).add(root.val);
        levelOrderBottom(arr,root.left,height+1);
        levelOrderBottom(arr,root.right,height+1);
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
