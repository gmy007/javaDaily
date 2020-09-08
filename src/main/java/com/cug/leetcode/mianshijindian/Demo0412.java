package com.cug.leetcode.mianshijindian;

import java.util.LinkedList;

public class Demo0412 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ret = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            ret += doPathSum(cur, sum);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }

        return ret;

    }

    public int doPathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        if (sum - root.val == 0)
            return 1 + doPathSum(root.left, sum - root.val) + doPathSum(root.right, sum - root.val);

        return doPathSum(root.left, sum - root.val) + doPathSum(root.right, sum - root.val);
    }

}
