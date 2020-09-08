package com.cug.leetcode;

import java.util.Hashtable;

public class Question146 {

    /**
     * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
     *
     * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
     * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     *
     * hashmap加双向链表
     */
    class LRUCache {
        class Node{
            Node prev;
            Node next;
            int key;
            int val;

        }
        private Hashtable<Integer,Node> hashtable=new Hashtable<>();
        private Node head;
        private Node tail;
        private int capacity,size;
        public LRUCache(int capacity) {
            this.capacity=capacity;
            this.size=0;
            this.head=new Node();
            this.tail=new Node();
            head.next=tail;
            tail.prev=head;
        }
        public void addNode(Node node){
            node.prev=head;
            node.next=head.next;
            head.next.prev=node;
            head.next=node;

        }
        public void removeNode(Node node){
            node.prev.next=node.next;
            node.next.prev=node.prev;

        }
        public void moveToHead(Node node){
            removeNode(node);
            addNode(node);
        }
        public  Node popTail(){
            Node node=tail.prev;
            removeNode(node);
            return node;

        }
        public int get(int key) {
            Node node = hashtable.get(key);
            if(node==null)
                return -1;
            moveToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            Node node = hashtable.get(key);
            if(node==null){
                Node cur = new Node();
                cur.key=key;
                cur.val=value;
                size++;
                addNode(cur);
                hashtable.put(key,cur);
                if(size>capacity){
                    Node rm = popTail();
                    hashtable.remove(rm.key);
                    --size;
                }

            }else {
                node.val=value;
                moveToHead(node);
            }

        }
    }
}
