package com.cug.demo0313;

public class pratice {

    static class Node{
        Node next;

    }
    public static Node reverse(Node head){
        Node newHead = new Node();
        while(head!=null){
            Node next=head.next;
            head.next=null;
            newHead.next=head;
            head=next;
        }

        return newHead.next;
    }
}
