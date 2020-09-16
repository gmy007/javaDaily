package com.cug.qiuzhao.meituan;


import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        infixOrder(root);
    }
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val){
            this.val=val;
        }
    }
    static void infixOrder(TreeNode root){
        if(root==null)return;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode p = root;
        stk.add(p);
        while(stk.isEmpty() == false) {
            if(p!=null &&  p.left!=null) {
                stk.add(p.left);
                p = p.left;
            }else {
                p = stk.pop();
                System.out.print(p.val+" ");
                if(p!=null && p.right!=null) {
                    stk.add(p.right);
                    p = p.right;
                }else
                    p = null;
            }

        }}
}
