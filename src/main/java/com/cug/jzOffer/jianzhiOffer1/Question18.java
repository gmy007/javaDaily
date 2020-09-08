package com.cug.jzOffer.jianzhiOffer1;

public class Question18 {
    //O(1)删除节点
    class Node{
        int val;
        Node next;

    }
    public void deleteNode(Node root,Node node){
        if(node.next==null){

            while (root.next!=node){
                root=root.next;
            }
            root.next=null;
        }else{
            node.val=node.next.val;

            node.next=node.next.next;
            node.next.next=null;
        }
        //综合看是0(1)
    }
}
