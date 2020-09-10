package com.cug.qiuzhao.kuaishou;

import java.util.Stack;

public class Demo206 {
    public static void main(String[] args) {
        /**
         * select avg(score) as avgScore uid username from user join score on user.uid = score.uid  where DateDiff(h,time,now())<1
         * order by avgScore desc
         */
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while(head!=null){
            stack.push(head);
            head=head.next;
        }
        ListNode root = new ListNode(-1);
        ListNode ret = root;
        while(!stack.isEmpty()){
            root.next=stack.pop();
            root = root.next;
        }
        root.next= null;
        return ret.next;
    }
}
