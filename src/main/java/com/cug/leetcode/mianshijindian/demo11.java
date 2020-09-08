package com.cug.leetcode.mianshijindian;

public class demo11 {
    /**实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
     * public int kthToLast(ListNode head, int k) {
     *         Stack<Integer> s=new Stack<>();
     *         while(head!=null){
     *             s.push(head.val);
     *             head=head.next;
     *         }
     *         while(--k>0)
     *             s.pop();
     *         return s.pop();
     *     }
     *
     *     双指针，一个节点先走K步；
     */
}
