package com.pigcanfly.leetcoding.s590;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * TODO: 中序遍历结果，翻转reverse List
 * @author Tobby Quinn
 * @date 2019/07/05
 */
public class NaryTreePostorderTraversal {
    public static  List<Integer> postorder(Node root) {
        if(root==null){
            return Arrays.asList();
        }
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Stack<Node> rootStack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node pop = stack.peek();
            if(pop.children!=null && pop!=(rootStack.isEmpty()?null:rootStack.peek()) ){
                int n =pop.children.size();
                for (int i = n-1; i>=0; i--) {
                    Node nd = pop.children.get(i);
                    stack.push(nd);

                }
                //将父节点添加进 另一个栈
                rootStack.push(pop);
            }else{
                Node remove = stack.pop();
                if(remove==rootStack.peek()){
                    rootStack.pop();
                }
                res.add(remove.val);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        ArrayList<Node> r1 = new ArrayList<>();
        ArrayList<Node> r2 = new ArrayList<>();
        r2.add(new Node(5,null));
        r2.add(new Node(6,null));
        Node root2 = new Node(3, r2);
        r1.add(root2);
        r1.add(new Node(2,null));
        r1.add(new Node(3,null));
        Node root = new Node(1, r1);
        postorder(root);
    }



   static  class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
