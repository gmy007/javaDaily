package com.cug.leetcode;

public class Demo92 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n)
            return head;
        ListNode ret = new ListNode(-1);
        n = n-m+1;
        m--;
        ListNode temp = ret;
        while(m>0){
            m--;
            temp.next = head;
            head = head.next;
            temp= temp.next;
        }
        ListNode root = new ListNode(-1);
        root.next = null;
        while(n>0){
            n--;
            ListNode next = head.next;
            head.next = root.next;
            root.next = head;
            head = next;
        }
        temp.next = root.next;
        while(root.next !=null)
            root=root.next;
        root.next = head;
        return ret.next;

    }
}
