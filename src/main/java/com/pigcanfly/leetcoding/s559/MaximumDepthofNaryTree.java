package com.pigcanfly.leetcoding.s559;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tobby Quinn
 * @date 2019/07/11
 */
public class MaximumDepthofNaryTree {

    public static int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        int n =root.children.size();
        if(n==0){
            return 1;
        }
        int max=1;
        for (int i = 0; i < n; i++) {
            int res=1;
            res+=maxDepth(root.children.get(i));
            max=max<res?res:max;
        }
        return max;


    }

    public static void main(String[] args) {
        ArrayList<Node> nodes1 = new ArrayList<>();
        ArrayList<Node> nodes3 = new ArrayList<>();
        nodes3.add(new Node(5,new ArrayList<>()));
        nodes3.add(new Node(6,new ArrayList<>()));
        Node n3 = new Node(3, nodes3);
        nodes1.add(n3);
        nodes1.add(new Node(2,new ArrayList<>()));
        nodes1.add(new Node(4,new ArrayList<>()));
        Node root = new Node(1,nodes1);
        int i = maxDepth(root);
        System.out.println(i);
    }




   static  class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
