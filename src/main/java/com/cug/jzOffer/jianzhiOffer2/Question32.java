package com.cug.jzOffer.jianzhiOffer2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Question32 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            result.add(cur.val);
            if(cur.left!=null)
                queue.add(cur.left);
            if(cur.right!=null)
                queue.add(cur.right);

        }
        return result;
    }
    //P30.1
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(pRoot==null)
            return result;
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list=new ArrayList<>();
            int size = queue.size();
            while(size-->0){
                TreeNode cur = queue.remove();
                list.add(cur.val);
                if(cur.left!=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
            }
            if(list.size()!=0)
                result.add(list);


        }
        return result;
    }
}
