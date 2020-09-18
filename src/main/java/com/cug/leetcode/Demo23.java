package com.cug.leetcode;

public class Demo23 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r)
            return lists[l];
        if (l > r)
            return null;
        int mid = (l + r) >> 1;
        return mergeTwoList(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoList(ListNode a, ListNode b) {
        if (a == null || b == null)
            return a == null ? b : a;
        ListNode root = new ListNode(-1);
        ListNode ret = root;
        while (a != null && b != null) {
            if (a.val < b.val) {
                root.next = a;
                a = a.next;
            } else {
                root.next = b;
                b = b.next;
            }
            root = root.next;
        }
        if (a != null)
            root.next = a;
        if (b != null)
            root.next = b;
        return ret.next;
    }
}
