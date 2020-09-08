package com.cug.jzOffer.jianzhiOffer2;

public class Question52 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null)
            return null;
        ListNode root=pHead1;
        int len1=0,len2=0;
        while(root!=null){
            root=root.next;
            len1++;
        }
        root=pHead2;
        while(root!=null){
            root=root.next;
            len2++;
        }
        if(len1>len2){
            for (int i = 0; i <len1-len2 ; i++) {
                pHead1=pHead1.next;
            }
        }else {
            for (int i = 0; i <len2-len1 ; i++) {
                pHead2=pHead2.next;
            }
        }
        while(pHead1!=pHead2&&pHead1!=null &&pHead2!=null){
            pHead1=pHead1.next;
            pHead2=pHead2.next;
        }
        return pHead1;
    }
}
