package com.cug.leetcode;

public class Demo148 {
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

    public ListNode sortList(ListNode head) {
        ListNode ret = new ListNode(-1);
        ret.next = head;
        int n = 0;
        for (ListNode i = head; i != null; i = i.next) n++;

        for (int i = 1; i < n; i = i * 2) {
            ListNode begin = ret;
            for (int j = 0; j + i < n; j = j + 2 * i) {
                ListNode first = begin.next,second = first;
                for (int k = 0; k < i; k++) {
                    second = second.next;
                }
                int f=0,s=0;
                while(f<i && s<i && second!=null){
                    if(first.val < second.val){
                        begin.next = first;
                        begin = begin.next;
                        first = first.next;
                        f++;
                    }else {
                        begin.next = second;
                        begin = begin.next;
                        second = second.next;
                        s++;
                    }
                }
                while(f<i){
                    begin.next =first;
                    first = first.next;
                    begin = begin.next;
                    f++;
                }
                while(s<i && second!=null){
                    begin.next = second;
                    second=second.next;
                    begin = begin.next;
                    s++;
                }
                begin.next = second;
            }
        }
        return ret.next;
    }
}
