package com.pigcanfly.leetcoding.s1305;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2020/01/13
 */
public class AllElementsinTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null){
            return Collections.emptyList();
        }else if(root1==null){
            return inOrder(root2,new ArrayList<>());
        }else if(root2==null){
            return inOrder(root1,new ArrayList<>());
        }
        inOrderAndInsert(root1,root2);
        return inOrder(root1,new ArrayList<>());
    }

    TreeNode insert(TreeNode root,int val){
        if(root==null){
            return new TreeNode(val);
        }
        if(val>=root.val){
            root.right=insert(root.right,val);
        }else{
            root.left=insert(root.left,val);
        }
        return root;
    }
    List<Integer> inOrder(TreeNode root,List<Integer> arr){
        if(root==null){
            return null;
        }
        inOrder(root.left,arr);
        arr.add(root.val);
        inOrder(root.right,arr);
        return arr;
    }
    void inOrderAndInsert(TreeNode insertTree,TreeNode root){
        if(root==null){
            return;
        }
        inOrderAndInsert(insertTree,root.left);
        insert(insertTree,root.val);
        inOrderAndInsert(insertTree,root.right);
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
