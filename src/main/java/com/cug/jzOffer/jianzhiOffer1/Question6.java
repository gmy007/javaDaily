package com.cug.jzOffer.jianzhiOffer1;

import java.util.ArrayList;
import java.util.Stack;

public class Question6 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> s=new Stack<>();
        while(listNode!=null){
            s.push(listNode.val);
            listNode=listNode.next;
        }
        ListNode node;
        while(!s.isEmpty()){
            result.add(s.pop());

        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


}
