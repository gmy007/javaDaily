package com.cug.jzOffer.jzOffer3;

public class Question63 {
    public int maxProfit(int[] prices) {
        if(prices.length==0||prices==null)
            return 0;

        int min=prices[0],max=0;
        for (int i = 0; i <prices.length ; i++) {
            min=Math.min(min,prices[i]);
            max=Math.max(max,prices[i]-min);

        }
        return max;
    }
}
