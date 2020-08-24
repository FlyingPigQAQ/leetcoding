package com.pigcanfly.leetcoding.s1302;

import java.util.*;

/**
 * @author tobbyquinn
 * @date 2020/01/06
 */
public class DeepestLeavesSum {
    public int deepestLeavesSum1(TreeNode root) {
        if(root==null){
            return 0;
        }
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        deepestLeavesSum(root,map,1);
        Integer maxDepth = map.keySet().stream().max((c1, c2) -> c1 - c2).get();
        return map.get(maxDepth).stream().mapToInt(Integer::intValue).sum();
    }
    public void deepestLeavesSum(TreeNode root, Map<Integer, ArrayList<Integer>> map,int depth) {
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            ArrayList<Integer> arr = map.getOrDefault(depth, new ArrayList<>());
            arr.add(root.val);
            map.put(depth,arr);
            return;
        }
        deepestLeavesSum(root.left,map,depth+1);
        deepestLeavesSum(root.right,map,depth+1);
    }

    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size(),res=0;
            //每次添加 都是相同深度的节点
            for (int i = 0; i <size; i++) {
                TreeNode poll = queue.poll();
                res+=poll.val;
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }
            }
            if(queue.isEmpty()){
                return res;
            }
        }
        return -1;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
