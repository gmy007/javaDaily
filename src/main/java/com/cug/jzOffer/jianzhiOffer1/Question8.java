package com.cug.jzOffer.jianzhiOffer1;

public class Question8 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
         if(pNode.right!=null){
             TreeLinkNode node=pNode.right;
             while(node.left!=null){
                 node=node.left;
             }
             return node;
         }else {

             while (pNode.next!=null){
                 TreeLinkNode parent=pNode.next;
                 if(parent.left==pNode)
                     return parent;
                 pNode=parent;
             }
         }
         return null;

    }
}
