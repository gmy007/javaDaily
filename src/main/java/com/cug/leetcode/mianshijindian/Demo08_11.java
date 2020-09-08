package com.cug.leetcode.mianshijindian;

import java.util.Arrays;

public class Demo08_11 {
    /**
     * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。
     * (结果可能会很大，你需要将结果模上1000000007)
     */
    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        int mod=1000000007;
        if(n<1)
            return n;
        dp[0]=1;
        int[] coins = new int[] {1, 5, 10, 25};
        for (int coin : coins) {
            for (int i = 1; i <=n; i++) {
                if(i>coin)
                    dp[i]=(dp[i]+dp[i-coin])%mod;
            }
        }
        return dp[n];
    }
}
