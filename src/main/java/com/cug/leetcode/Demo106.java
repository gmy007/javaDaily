package com.cug.leetcode;
import java.util.HashMap;
public class Demo106 {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    int lastIdx ;
    HashMap<Integer , Integer> maps= new HashMap<>();
    int[] inorder;
    int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        this.lastIdx = postorder.length-1;
        for(int i =0;i<inorder.length;i++){
            maps.put(inorder[i],i);
        }
        return helper(0,inorder.length-1);
    }
    public TreeNode helper(int left,int right){
        if(left>right)
            return null;
        int rootVal = postorder[lastIdx];
        TreeNode root = new TreeNode(rootVal);
        int index = maps.get(rootVal);
        lastIdx--;
        root.right = helper(index+1,right);
        root.left = helper(left,index-1);

        return root;
    }
}
