package com.cug.leetcode;

public class Question64 {
    /*
    给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    说明：每次只能向下或者向右移动一步。
        输入:
    [
      [1,3,1],
      [1,5,1],
      [4,2,1]
    ]
    输出: 7
    解释: 因为路径 1→3→1→1→1 的总和最小。
     */
    public int minPathSum(int[][] grid) {
        int rows=grid.length,cols=grid[0].length;
        int[][] dp =new int[rows][cols];
        //也可以使用原数组替代，不需要额外空间
        for (int i = rows-1; i >=0 ; i--) {
            for (int j = cols-1; j >=0 ; j--) {
                if(i==rows-1 && j!=cols-1)
                    dp[i][j]=grid[i][j]+dp[i][j+1];
                else if(i!=rows-1 && j==cols-1)
                    dp[i][j]=grid[i][j]+dp[i+1][j];
                else if(i!=rows-1 && j!=cols-1)
                    dp[i][j]=grid[i][j]+Math.min(dp[i+1][j],dp[i][j+1]);
                else dp[i][j]=grid[i][j];
            }

        }
        return dp[0][0];
    }
}
