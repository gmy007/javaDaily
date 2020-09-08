package com.cug.jzOffer.jianzhiOffer2;

import java.util.HashMap;
import java.util.Map;

public class Question35 {

    //复制复杂链表，用一个映射存放老与新链表节点的对应关系
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null)
            return pHead;
        Map<RandomListNode, RandomListNode> nodeMap = new HashMap<>();
        RandomListNode root=pHead;
        RandomListNode newPhead=new RandomListNode(pHead.label);
        RandomListNode new2=newPhead;
        nodeMap.put(pHead,newPhead);
        while(root.next!=null){
            newPhead.next=new RandomListNode(root.next.label);
            nodeMap.put(root.next,newPhead.next);
            newPhead=newPhead.next;
            root=root.next;
        }
        newPhead.next=null;
        root=pHead;
        while(root!=null){
            if(root.random!=null)
                new2.random=nodeMap.get(root.random);

            root=root.next;
            new2=new2.next;
        }
        return nodeMap.get(pHead);

    }

}
