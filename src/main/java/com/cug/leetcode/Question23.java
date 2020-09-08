package com.cug.leetcode;

import java.util.List;
import java.util.PriorityQueue;

public class Question23 {
    public class ListNode {
      int val;
      ListNode next;
        ListNode(int x) { val = x; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            if(lists[i]!=null)
                minHeap.add(lists[i]);
        }
        ListNode root = new ListNode(-1);
        root.next=null;
        ListNode node=root;
        while(!minHeap.isEmpty()){
            ListNode cur=minHeap.poll();
            node.next=cur;
            if(cur.next!=null)
                minHeap.add(cur.next);
            node=node.next;
        }
        return root.next;

    }
}
