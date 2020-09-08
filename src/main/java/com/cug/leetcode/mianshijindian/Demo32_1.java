package com.cug.leetcode.mianshijindian;

import java.util.ArrayList;
import java.util.LinkedList;


public class Demo32_1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int[] levelOrder(TreeNode root) {
        if(root==null)
            return new int[1];
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        TreeNode cur;
        ArrayList<Integer> retList = new ArrayList<>();
        while(queue.size()!=0&&(cur=queue.removeFirst())!=null){
            retList.add(cur.val);
            if(cur.left!=null)queue.add(cur.left);
            if(cur.right!=null)queue.add(cur.right);
        }
        int[] ret=new int[retList.size()];
        for (int i = 0; i < retList.size(); i++) {
            ret[i]=retList.get(i);

        }
        return ret;
    }
}
