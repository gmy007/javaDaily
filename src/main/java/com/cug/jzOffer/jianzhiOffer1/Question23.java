package com.cug.jzOffer.jianzhiOffer1;

public class Question23 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        new Question23().test();

    }
    public ListNode answer(ListNode pHead){
        if(pHead==null || pHead.next==null)
            return null;
        ListNode p1=pHead;
        ListNode p2=pHead;
        do{
            p1=p1.next;
            p2=p2.next.next;
        }while (p1!=null && p2.next!=null &&p1!=p2);

        if(p1==null || p2.next==null)
            return null;
        while(pHead!=p1){
            p1=p1.next;
            pHead=pHead.next;
        }
        return pHead;
    }
    public void test(){
        ListNode root = this.new ListNode(1);
        ListNode root2 = this.new ListNode(2);
        ListNode root3 = this.new ListNode(3);
        ListNode root4 = this.new ListNode(4);
        ListNode root5 = this.new ListNode(5);
        root.next=root2;
        root2.next=root3;
        root3.next=root4;
        root4.next=root5;
        root5.next=root3;
        ListNode listNode = this.EntryNodeOfLoop(root);
        System.out.println(listNode.val);
    }
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead==null||pHead.next==null)
            return null;
        ListNode p1 =pHead;
        ListNode p2=pHead.next;

        while(p1!=null && p2.next!=null && p1!=p2){
            p1=p1.next;
            p2=p2.next.next;

        }//相遇一定在环内
        if(p1==null || p2.next==null)
            return null;

        int n=1;
        while(p1.next!=p2){
            p1=p1.next;
            n++;
        }//从相遇节点处走一圈，算出环长度
        p1=pHead;
        p2=pHead;
        for (int i = 0; i < n; i++) {
            p1=p1.next;

        }
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }//一个先出发环长，一个从头，两个相遇即入口。
        return p1;
    }
}
