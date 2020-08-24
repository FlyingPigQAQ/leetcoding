package com.pigcanfly.leetcoding.s1490;

import java.util.*;

/**
 * @author tobbyquinn
 * @date 2020/08/12
 */
public class CloneNaryTree {
    public Node cloneTree1(Node root) {
        if (root == null) {
            return null;
        }
        Node clone = new Node(root.val);
        cloneTree1(root,clone);
        return clone;
    }
    public void cloneTree1(Node root,Node cloneNode) {
        if (root == null) {
            return ;
        }
        for (Node child : root.children) {
            Node childCloneNode = new Node(child.val);
            cloneTree1(child,childCloneNode);
            cloneNode.children.add(childCloneNode);
        }
    }

    public Node cloneTree2(Node root) {
        if (root == null) {
            return null;
        }
        Node clone = new Node(root.val);
        for (Node child : root.children) {
            clone.children.add(cloneTree2(child));
        }
        return clone;
    }
}

class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
}
