package com.pigcanfly.leetcoding.s1506;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2020/08/14
 */
public class FindRootofNAryTree {
    public Node findRoot1(List<Node> tree) {
        HashSet<Node> childs = new HashSet<>();
        for (int i = 0; i < tree.size(); i++) {
            childs.addAll(tree.get(i).children);
        }
        tree.removeAll(childs);
        return tree.get(0);
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
