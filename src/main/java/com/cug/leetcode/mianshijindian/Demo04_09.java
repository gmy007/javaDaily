package com.cug.leetcode.mianshijindian;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo04_09 {
    /**
     * 从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。给定一个由不同节点组成的二叉树，输出所有可能生成此树的数组。
     * 示例:
     * 给定如下二叉树
     *         2
     *        / \
     *       1   3
     * 返回:
     * [
     *    [2,1,3],
     *    [2,3,1]
     * ]
     */
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

    public List<List<Integer>> BSTSequences(TreeNode root) {
        if(null==root){
            List<List<Integer>>  list=new ArrayList<>();
            list.add(new ArrayList<>());
            return list;
        }
        /*
        递归分别找左子树和右子树的顺序排列。
         */
        List<List<Integer>> left=BSTSequences(root.left);
        List<List<Integer>> right=BSTSequences(root.right);
        List<List<Integer>> ret=new ArrayList<>();
        LinkedList<Integer> temp=new LinkedList<>();//用一个队列，保证合并时移除最后一个元素
        temp.add(root.val);
        for (List<Integer> l : left) {
            for (List<Integer> r : right) {
                    merge(l,r,0,0,temp,ret);
            }
        }
        return ret;
    }

    private void merge(List<Integer> l, List<Integer> r, int lIndex, int rIndex, LinkedList<Integer> temp,List<List<Integer>> ret) {
        if(temp.size()==l.size()+r.size()+1){
            ret.add(new ArrayList<>(temp));
            return;
        }
        /*
        保证左右子树的根节点，一定在自己的左右孩子节点之前，左右孩子可以互换位置，根不能和左右孩子互换位置
         */
        if(lIndex<l.size()){
            temp.addLast(l.get(lIndex));
            merge(l,r,lIndex+1,rIndex,temp,ret);
            temp.removeLast();

        }
        if(rIndex<r.size()){
            temp.addLast(r.get(rIndex));
            merge(l,r,lIndex,rIndex+1,temp,ret);
            temp.removeLast();
        }
    }
}
