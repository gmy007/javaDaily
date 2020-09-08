package com.cug.jzOffer.jianzhiOffer2;

public class Question55 {

     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }
    public int TreeDepth(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        int left=TreeDepth(root.left)+1;
        int right=TreeDepth(root.right)+1;
        return Math.max(left,right);
    }
}
