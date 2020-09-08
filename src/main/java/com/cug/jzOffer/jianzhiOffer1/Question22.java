package com.cug.jzOffer.jianzhiOffer1;

public class Question22 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if(head==null)
            return null;
        ListNode p1=head;
        ListNode p2=head;
        while(p1!=null && k-->0){
            p1=p1.next;
        }
        if(k>0)
            return null;
        while(p1!=null){//不是p1.next==null
            p1=p1.next;
            p2=p2.next;
        }
        return p2;
    }
}
