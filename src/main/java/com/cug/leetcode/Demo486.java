package com.cug.leetcode;

public class Demo486 {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        //dp[i][j]代表数组下标i到j的当前玩家差值最大
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = n-2; i >=0 ; i--) {
            for (int j = i+1; j <n ; j++) {
                dp[i][j] = Math.max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1]);

            }

        }
        return dp[0][n-1]>=0;

    }
}
