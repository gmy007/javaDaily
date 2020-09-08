package com.cug.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Question983 {
    int[] costs;
    Integer[] memo;
    Set<Integer> dayset;
    public int mincostTickets(int[] days, int[] costs) {
        memo=new Integer[366];
        this.costs=costs;
        dayset=new HashSet<>();
        for (int i = 0; i < days.length; i++) {
            dayset.add(days[i]);
        }
        return dp(1);
    }
    public int dp(int i){
        if(i>365)
            return 0;
        if(memo[i]!=null)
            return memo[i];
        if(dayset.contains(i))
            memo[i]=Math.min(dp(i+1)+costs[0],Math.min(dp(i+7)+costs[1],dp(i+30)+costs[2]));
        else
            memo[i]=dp(i+1);
        return memo[i];
    }
}
