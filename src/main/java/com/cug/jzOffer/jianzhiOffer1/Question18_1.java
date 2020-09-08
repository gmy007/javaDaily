package com.cug.jzOffer.jianzhiOffer1;

public class Question18_1 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null||pHead.next==null)
            return pHead;
        ListNode next=pHead.next;
        if(pHead.val==next.val){
            while(pHead.val==next.val)
                next=next.next;
            return deleteDuplication(next);
        }else {
            pHead.next=deleteDuplication(next);
            return pHead;
        }
    }

}
