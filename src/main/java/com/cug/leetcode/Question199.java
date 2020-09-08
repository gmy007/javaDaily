package com.cug.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Question199 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer, Integer> maps = new HashMap<>();
        int maxdep=-1;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(0);
        while(!nodeStack.isEmpty()){
            int depth=depthStack.pop();
            TreeNode cur = nodeStack.pop();

            if(cur!=null){
                maxdep=Math.max(depth,maxdep);
                if(!maps.containsKey(depth)){
                    maps.put(depth,cur.val);
                }
                nodeStack.push(cur.left);
                nodeStack.push(cur.right);
                depthStack.push(depth+1);
                depthStack.push(depth+1);
            }

        }
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i <=maxdep; i++) {
            ret.add(maps.get(i));
        }
        return ret;
    }
}
