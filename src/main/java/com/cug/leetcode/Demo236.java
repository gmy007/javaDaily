package com.cug.leetcode;

public class Demo236 {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    TreeNode ret = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return ret;
    }
    public boolean dfs(TreeNode root,TreeNode p,TreeNode q){
        if(root == null) return false;
        boolean left = dfs(root.left,p,q);
        boolean right = dfs(root.right,p,q);
        if((left && right) || ((root.val == p.val||root.val == q.val)&&(left || right)))
            ret = root;
        return left||right||root.val == p.val||root.val == q.val;
    }
}
