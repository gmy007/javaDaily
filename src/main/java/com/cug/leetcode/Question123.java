package com.cug.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Question123 {
    public int maxProfit(int[] prices) {
        if(prices.length<=1)
            return 0;
        int n = prices.length;
        int s0=prices[0],s1=Integer.MIN_VALUE,s2=Integer.MIN_VALUE,s3=Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            s0=Math.max(s0,-prices[i]);
            s1=Math.max(s1,s0+prices[i]);
            s2=Math.max(s2,s1-prices[i]);
            s3=Math.max(s3,s2+prices[i]);
        }
        return Math.max(s3,0);
    }
}
