package com.cug.leetcode.mianshijindian;

import java.lang.reflect.Array;
import java.util.*;

public class Demo32_3 {
    /**
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
     * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null)
            queue.add(root);
        List<List<Integer>>ret = new ArrayList<>();
        while(!queue.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            for (int i = queue.size(); i >0; i--) {
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if(cur.left!=null)queue.add(cur.left);
                if(cur.right!=null)queue.add(cur.right);
            }
            if(ret.size()%2==1)Collections.reverse(temp);
            ret.add(temp);
        }
        return ret;

    }
}
