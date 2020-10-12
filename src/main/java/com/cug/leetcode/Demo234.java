package com.cug.leetcode;

public class Demo234 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next  = reverse(second);
        ListNode p1 = head;
        ListNode p2 = slow.next;
        while(p2!=null){
            if(p1.val!=p2.val)
                return false;
            p1=p1.next;
            p2=p2.next;
        }
        slow.next = reverse(slow.next);
        return true;

    }
    public ListNode reverse(ListNode root){
        ListNode pre = null;
        while(root!=null){
            ListNode next = root.next;
            root.next = pre;
            pre = root;
            root=next;
        }
        return pre;
    }
}
