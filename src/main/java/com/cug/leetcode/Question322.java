package com.cug.leetcode;

import java.util.Arrays;

public class Question322 {
    Integer[] memo;
    public int coinChange(int[] coins, int amount) {
        if(amount<0)
            return -1;
        memo=new Integer[amount+1];
        return 0;
    }

    public static void main(String[] args) {
        Question322 q = new Question322();
        int[] coins = {1,2,5};
        int tes = q.tryCoinChange(coins, 10);
        System.out.println(tes);
    }
    public int  tryCoinChange(int[] coins, int amount){
        if(amount==0)
            return 0;
        if(amount<0)
            return -1;
        if(memo[amount]!=null)return memo[amount];

        int min=Integer.MAX_VALUE;
        for (int i = 0; i <coins.length ; i++) {
            int count=tryCoinChange(coins,amount-coins[i]);
            if(count>=0&&count<min)
                min=count+1;

        }
        memo[amount]=(min==Integer.MAX_VALUE)?-1:min;
        return memo[amount];
    }

    public int dpCoinChange(int[] coins, int amount){
        Integer[] dp=new Integer[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for (int i = 1; i <amount+1 ; i++) {
            for (int j = 0; j <coins.length ; j++) {
                if(i>=coins[j])
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }

}
