package com.cug.jzOffer.jianzhiOffer1;

public class Question25 {
    /*合并两个有序链表
    头插法或递归
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode pHead;
        if (list1.val < list2.val) {
            pHead = list1;
            pHead.next = Merge(pHead.next, list2);

        } else {
            pHead = list2;
            pHead.next = Merge(pHead.next, list1);
        }
        return pHead;
    }
}
