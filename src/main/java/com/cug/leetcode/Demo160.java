package com.cug.leetcode;

public class Demo160 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headB==null || headA == null)
            return null;
        ListNode p = headA, q = headB;
        while(p != q){
            p = p.next;
            q = q.next;
            if(p==null && q==null)
                return null;
            if(q == null)
                q=headA;
            if(p == null)
                p=headB;
        }
        return p;
    }
}
