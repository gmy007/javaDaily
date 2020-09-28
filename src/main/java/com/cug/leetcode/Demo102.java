package com.cug.leetcode;
import java.util.*;
public class Demo102 {


      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return ret;
        queue.add(root);
        while(!queue.isEmpty()){
            LinkedList<TreeNode> temp = new LinkedList<>();
            ArrayList<Integer> cur = new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                cur.add(node.val);
                if(node.left !=null)
                    temp.addLast(node.left);
                if(node.right !=null)
                    temp.addLast(node.right);
            }
            ret.add(cur);
            queue = temp;
        }
        return ret;
    }
}
