package com.pigcanfly.leetcoding.s589;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Tobby Quinn
 * @date 2019/07/05
 */
public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        if(root==null){
            return Arrays.asList();
        }
        stack.push(root);
        ArrayList<Integer> res = new ArrayList<>();
        while(!stack.isEmpty()){
            Node pop = stack.pop();
            res.add(pop.val);
            if(pop.children!=null){
                int n = pop.children.size();
                for (int i = n-1; i >=0 ; i--) {
                    stack.push(pop.children.get(i));
                }
            }

        }
        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
