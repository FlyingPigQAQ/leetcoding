package com.pigcanfly.leetcoding.s706;

/**
 *
 * TODO:reSize()
 * TODO:添加TreeNode
 * @author Tobby Quinn
 * @date 2019/08/12
 */
public class MyHashMap {

    static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V vlaue, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = vlaue;
            this.next = next;
        }

    }

    private Node[] arr;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        arr = new Node[16];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int index = hash(key);
        if (arr[index] != null) {
            Node head = arr[index];
            Node parent = head;
            boolean lastAppend = true;

            while (head != null) {
                if (head.key.equals(key)) {
                    lastAppend = false;
                    head.value = value;
                    size--;
                    break;
                }
                parent=head;
                head = head.next;
            }
            if (lastAppend) {
                parent.next = new Node(index, key, value, null);
            }
        } else {
            arr[index] = new Node(index, key, value, null);
        }
        size++;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int index = hash(key);
        if (arr[index] == null) {
            return -1;
        }
        Node head = arr[index];
        while (head != null) {
            if (head.key.equals(key)) {
                return (int) head.value;
            }
            head = head.next;
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int index = hash(key);
        if (arr[index] == null) {
            return;
        }
        Node head = arr[index];
        Node p = head;
        Node node = null;
        if (head.key.equals(key)) {
            node = head;
        } else if (head.next != null) {

            Node e = head.next;

            do {
                if (e.key.equals(key)) {
                    node = e;
                    break;
                }
                p = e;
            } while ((e = e.next) != null);
        }
        if(node!=null){
            if (node != p) {
                p.next = node.next;
            } else if (node == p) {
                arr[index] = node.next;
            }
            --size;

        }

    }


    private int hash(int key) {
        return key % arr.length;
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1,1);

        myHashMap.put(1,2);
        myHashMap.put(17,3);
        //myHashMap.remove(1);
       // myHashMap.remove(1);
        myHashMap.remove(17);
        int i = myHashMap.get(1);
        System.out.println(i);
    }

}
