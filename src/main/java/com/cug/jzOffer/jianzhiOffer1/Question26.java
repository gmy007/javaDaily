package com.cug.jzOffer.jianzhiOffer1;

public class Question26 {
    /**
     * 数的子结构
     * 判断r2是否r1的子结构，多重递归调用
     *
     */
     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null |root2==null)
            return false;
        return isSubtreeWithRoot(root1,root2)||isSubtreeWithRoot(root1.left,root2)||isSubtreeWithRoot(root1.right,root2);
    }
    public boolean isSubtreeWithRoot(TreeNode root1,TreeNode root2){
         if(root2==null)
             return true;
         if(root1==null)
             return false;
         if(root1.val!=root2.val)
             return false;
         return isSubtreeWithRoot(root1.left,root2.left)&&isSubtreeWithRoot(root1.right,root2.right);
    }
}
