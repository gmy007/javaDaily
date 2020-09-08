package com.cug.leetcode.mianshijindian;

public class Demo08_01 {
    //简单dp
    public int waysToStep(int n) {
        if(n<3)
            return n;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        int mod=1000000007;
        for (int i = 4; i <=n; i++) {
            dp[i]=(dp[i-1]+dp[i])%mod;
            dp[i]=(dp[i-2]+dp[i])&mod;
            dp[i]=(dp[i-3]+dp[i])%mod;
        }
        return dp[n];

    }
}
