package com.cug.leetcode.mianshijindian;

public class demo10 {
    /**
     * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
     */

    /**
     *      Set<Integer> set=new HashSet<>();
     *     public ListNode removeDuplicateNodes(ListNode head) {
     *             if(head==null)
     *                 return head;
     *             if(set.add(head.val)){
     *                 head.next=removeDuplicateNodes(head.next);
     *                 return head;
     *             }else
     *             //如果已有当前元素，直接返回下一个，当前元素不链接
     *                 return removeDuplicateNodes(head.next);
     *
     *     }
     *     递归删除。
     */
}
