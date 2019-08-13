package com.pigcanfly.leetcoding.s637;

import java.util.*;

/**
 * @author Tobby Quinn
 * @date 2019/08/04
 */
public class AverageofLevelsinBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> temp = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            double size=queue.size();
            double total=0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                total+=poll.val;
                if(poll.left!=null){
                    temp.add(poll.left);
                }
                if(poll.right!=null){
                    temp.add(poll.right);
                }
            }
            res.add(total/size);
            total=0;
            Queue<TreeNode> tmp = queue;
            queue=temp;
            temp=tmp;

        }
        return res;
    }










    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
