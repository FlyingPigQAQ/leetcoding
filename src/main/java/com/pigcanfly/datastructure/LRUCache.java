package com.pigcanfly.datastructure;

import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2020/07/03
 */
public class LRUCache {
    static class LRUNode {
        String key;
        String value;


        LRUNode pre;
        LRUNode next;

        LRUNode(String key,String value){
            this.key=key;
            this.value=value;
        }


    }
    private HashMap<String,LRUNode> cache = null;
    private int limit;
    private LRUNode head,tail;
    public LRUCache(int size){
        this.limit=size;
        cache=new HashMap<String,LRUNode>(size);
    }
    public void put(String key,String value){
        LRUNode node = cache.get(key);
        if(node==null){
            if(cache.size()>=limit){
                String oldKey = removeNode(tail);
                cache.remove(oldKey);
            }
            node= new LRUNode(key,value);
            addNode(node);
            cache.put(key,node);
        }else{
            node.value=value;
            refreshNode(node);
        }
    }

    private String removeNode(LRUNode node) {
        if(node==head && node==tail){
            head=null;
            tail=null;
        }else if(node==head){
            node.next.pre=null;
            head=node.next;
        }else if(node==tail){
            node.pre.next=null;
            tail=node.pre;
        }else{
            node.pre.next=node.next;
            node.next.pre=node.pre;
        }
        String removeKey=node.key;
        return removeKey;
    }

    private void addNode(LRUNode node) {
        if(head==null){
            head=node;
            tail=node;
        }else{
            node.next=head;
            head.pre=node;
            head=node;
        }
    }

    public String get(String key){
        LRUNode node = cache.get(key);
        if(node!=null){
            refreshNode(node);
            return node.value;
        }
        return null;
    }

    private void refreshNode(LRUNode node) {
        if(node==head){
            return;
        }
        removeNode(node);
        addNode(node);
    }

    public void delete(String key){
        LRUNode node = cache.get(key);
        if(node!=null){
            removeNode(node);
            cache.remove(key);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put("1","user1");
        lruCache.put("2","user2");
        System.out.println(lruCache.get("1"));
        System.out.println(lruCache.get("2"));
        lruCache.put("3","user3");
        lruCache.put("4","user4");
        lruCache.put("2","user2 update");
        System.out.println(lruCache.get("2"));

    }

}
