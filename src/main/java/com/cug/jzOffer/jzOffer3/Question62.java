package com.cug.jzOffer.jzOffer3;

public class Question62 {
    public static void main(String[] args) {
        Question62 q = new Question62();
        int i = q.LastRemaining_Solution(5, 3);
        System.out.println(i);
    }
    public class LinkedNode{
        LinkedNode next;
        int val;
        public LinkedNode(int val){
            this.val=val;
        }
        public LinkedNode(){
        };

    }
    public int LastRemaining_Solution(int n, int m) {
        if(m==0||n==0)
            return -1;
        LinkedNode root = new LinkedNode();
        LinkedNode node=root;
        for (int i = 0; i <n ; i++) {
            node.val=i;
            if(i!=n-1){
                node.next=new LinkedNode();
                node=node.next;
            }
        }
        node.next=root;
        while(root.val!=node.val){

            for (int i = 0; i <m-1 ; i++) {
                root=root.next;
                node=node.next;
            }

            node.next=root.next;
            LinkedNode deleteRoot=root;
            root=root.next;
            deleteRoot.next=null;
        }
        return root.val;

    }
}
