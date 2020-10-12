package com.cug.leetcode;

import java.util.*;

public class Demo143 {

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

    class Solution {
        public void reorderList(ListNode head) {

            List<ListNode> lists = new LinkedList<>();
            while (head != null) {
                lists.add(head);
                head = head.next;
            }
            int i = 0, j = lists.size() - 1;
            while (i < j) {
                lists.get(i).next = lists.get(j);
                i++;
                if(i == j)
                    break;
                lists.get(j).next = lists.get(i);
                j--;
            }
            lists.get(i).next=null;
        }
    }
}
