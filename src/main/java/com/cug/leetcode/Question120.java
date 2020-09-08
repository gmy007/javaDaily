package com.cug.leetcode;

import java.util.List;

public class Question120 {
    /*
    给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
    例如，给定三角形：
    [
        [2],
       [3,4],
      [6,5,7],
     [4,1,8,3]
    ]
     */
    Integer[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        memo=new Integer[triangle.size()][triangle.size()];
        return diguiMinWithMemo(triangle,0,0);
    }
    /*
    递归，自顶向下,最上层根需要下层或下右的最小路径值,f(0,0)=min(f(1,0),f(1,1));
                                                      ↓
                                               f(n,n)=nums[n][n]
     */
    public int diguiMin(List<List<Integer>> triangle ,int r ,int c){
        if(r==triangle.size()-1)
            return  triangle.get(r).get(c);
        int left=diguiMin(triangle,r+1,c);
        int right=diguiMin(triangle,r+1,c+1);
        return Math.min(left,right)+triangle.get(r).get(c);
    }

    /*
    递归调用，使用记忆化搜索
     */

    public int diguiMinWithMemo(List<List<Integer>> triangle ,int r ,int c){
        if(memo[r][c]!=null)
            return memo[r][c];
        if(r==triangle.size()-1)
            return memo[r][c] =triangle.get(r).get(c);
        int left=diguiMinWithMemo(triangle,r+1,c);
        int right=diguiMinWithMemo(triangle,r+1,c+1);
        return memo[r][c] =Math.min(left,right)+triangle.get(r).get(c);
    }

    /*
    dp
     */
    public int dpMin(List<List<Integer>> triangle){
        int rows=triangle.size();
        int[] dp=new int[rows+1];
        for (int i = rows-1; i >=0 ; i--) {
            for (int j = 0; j <=rows ; j++) {
                dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
