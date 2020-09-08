package com.cug.jzOffer.jianzhiOffer1;

public class Question27 {

     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }
    public void Mirror(TreeNode root) {
         if (root==null ||(root.left==null && root.right==null))
             return ;
         Mirror(root.left);
         Mirror(root.right);
         TreeNode left=root.left;
         root.left=root.right;
         root.right=left;
    }

}
