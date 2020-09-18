package com.cug.leetcode;


import java.util.LinkedList;


public class Demo25 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        new Demo25().reverseKGroup(node1, 2);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;
        return reverse(head, new LinkedList<ListNode>(), 0, k);
    }

    public ListNode reverse(ListNode root, LinkedList<ListNode> stack, int cur, int k) {
        if (root == null && cur != k) {
            return stack.peekFirst();
        }
        ListNode node = new ListNode(-1);
        ListNode ret = node;
        if (cur % k == 0) {
            cur = 0;
            while (!stack.isEmpty()) {
                node.next = stack.removeLast();
                node = node.next;
            }
            node.next = null;
        }
        if (root == null)
            return ret.next;
        stack.addLast(root);
        node.next = reverse(root.next, stack, cur + 1, k);
        return ret.next;
    }

}
