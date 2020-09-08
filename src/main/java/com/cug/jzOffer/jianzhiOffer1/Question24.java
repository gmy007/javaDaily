package com.cug.jzOffer.jianzhiOffer1;

public class Question24 {
    /*
    反转链表，可以选择头插法，也可以原地反转，要记录当前节点的next
    原地反转可以写为递归调用
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        ListNode newListNode =new ListNode(-1);
        while(head!=null){
            ListNode next=head.next;
            head.next=newListNode.next;
            newListNode.next=head;
            head=next;
        }
        return newListNode.next;
    }
    public ListNode Reverse(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode next=head.next;
        head.next=null;
        ListNode reverse = Reverse(next);
        next.next=head;
        return reverse;
    }
}
