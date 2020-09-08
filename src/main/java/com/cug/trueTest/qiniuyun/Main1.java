package com.cug.trueTest.qiniuyun;

public class Main1 {
    public static  class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val){
        this.val=val;
    }
  }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node=new ListNode(2);
        root.next=node;
        node.next=new ListNode(3);node=node.next;
        node.next=new ListNode(4);node=node.next;
        node.next=new ListNode(5);node=node.next;
        ListNode listNode = ExchangeOddEvenNode(root);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode    =listNode.next;
        }

    }
    public static ListNode ExchangeOddEvenNode (ListNode input) {
        if(input==null || input.next==null)
            return input;
        ListNode pre=new ListNode(0);
        ListNode ret=pre;
        pre.next=input;
        while(input!=null&& input.next!=null){
            pre.next=input.next;
            input.next=pre.next.next;
            pre.next.next=input;
            pre=input;
            input=input.next;
        }

        return ret.next;
    }
}
