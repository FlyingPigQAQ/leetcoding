package com.pigcanfly.leetcoding.s146;

import java.util.HashMap;

/**
 * @author Tobby Quinn
 * @date 2019/05/26
 */
public class LRUCache {
    /**
     * 双向链表
     */
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> cache = new HashMap<>();
    private Node head;
    private Node tail;
    /**
     * 最大容量
     */
    private int capacity;
    /**
     * 当前缓存数
     */
    private int count;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        head = new Node();
        tail = new Node();

        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;

    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveNodeToTop(node);
        return node.value;

    }

    public void put(int key, int value) {
        //如果包含key
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveNodeToTop(node);
        } else {
            Node insNode = new Node(key, value);
            if (count < capacity) {
                cache.put(key, insNode);
            } else {
                //pop tail
                Node lastNode = tail.prev;
                Node secondeLastNode = lastNode.prev;
                lastNode.next = null;
                lastNode.prev = null;
                secondeLastNode.next = tail;
                tail.prev=secondeLastNode;
                cache.remove(lastNode.key);
                count--;
                System.out.println("出栈:key="+lastNode.key);
            }
            Node next = head.next;
            head.next = insNode;
            next.prev=insNode;
            insNode.prev=head;
            insNode.next=next;
            cache.put(key,insNode);

            count++;
        }

    }

    private void moveNodeToTop(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        node.next = null;
        node.prev = null;

        prev.next = next;
        next.prev = prev;
        //将该节点移动的头部
        Node headNext = head.next;

        head.next = node;
        headNext.prev = node;
        node.prev=head;
        node.next=headNext;
    }
}

class Test146 {
    public static void main(String[] args) {


        //Your LRUCache object will be instantiated and called as such:
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        int r1 = cache.get(1);// returns 1
        System.out.println(r1);

        cache.put(3, 3);    // evicts key 2
        int r2 = cache.get(2);// returns -1 (not found)
        System.out.println(r2);

        cache.put(4, 4);    // evicts key 1
        int r3 = cache.get(1);// returns -1 (not found)
        System.out.println(r3);
        int r4 = cache.get(3);// returns 3
        System.out.println(r4);
        int r5 = cache.get(4);// returns 4
        System.out.println(r5);

    }
}
