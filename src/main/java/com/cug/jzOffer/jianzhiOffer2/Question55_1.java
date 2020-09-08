package com.cug.jzOffer.jianzhiOffer2;

public class Question55_1 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    boolean isBalance=true;
    public boolean isBalanced(TreeNode root){
        TreeDepth(root);
        return isBalance;

    }
    public int TreeDepth(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        int left=TreeDepth(root.left);
        int right=TreeDepth(root.right);
        if(Math.abs(left-right)>1)
            isBalance=false;
        return 1+Math.max(left,right);
    }
}
