package com.cug.leetcode;

public class Demo124 {


      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root);
        return ret;
    }
     int ret = Integer.MIN_VALUE;
    public int dfs(TreeNode root){
          if(root == null)
              return 0;
          int left = Math.max(dfs(root.left),0);
          int right = Math.max(dfs(root.right),0);
          ret = Math.max(ret,left+right+ root.val);
          return root.val+Math.max(left,right);

    }
}
