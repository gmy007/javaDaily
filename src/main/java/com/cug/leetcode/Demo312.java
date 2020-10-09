package com.cug.leetcode;

public class Demo312 {
    public int maxCoins(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int n = nums.length;
        int[] val = new int[n + 2];
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        val[0] = val[n + 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum +=dp[i][k]+dp[k][j];
                    dp[i][j] = Math.max(dp[i][j],sum);
                }
            }
        }
        return dp[0][n+1];

    }
}
