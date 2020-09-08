package com.cug.jzOffer.jianzhiOffer1;

public class Question7 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode treeNode = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return treeNode;

    }

    public TreeNode reConstructBinaryTree(int[] pre, int strPre, int endPre, int[] in, int strIn, int endIn) {
        if (strPre > endPre || strIn > endIn)
            return null;
        TreeNode root = new TreeNode(pre[strPre]);
        for (int i = strIn; i <= endIn; i++) {
            if(in[i]==pre[strPre]){
                root.left=reConstructBinaryTree(pre,strPre+1,i-strIn+strPre,in,strIn,i-1);
                //关键在于两个数组的起始和终止下标
                //
                root.right=reConstructBinaryTree(pre,strPre+1+i-strIn,endPre,in,i+1,endIn);
                break;
            }

        }

        return root;
    }

}
