package com.cug.leetcode;

public class Question122 {
    public int maxProfit(int[] prices) {
        if(prices.length==1)
            return 0;
        int n = prices.length;
        int ret=0;
        for (int i = 1; i < n; i++) {
            if(prices[i-1]<prices[i]){
                ret+=prices[i]-prices[i-1];
            }
        }
        return ret;
    }
}
