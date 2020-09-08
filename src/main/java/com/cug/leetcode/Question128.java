package com.cug.leetcode;

import java.util.HashSet;

public class Question128 {

    public int longestConsecutive(int[] nums) {
        int max=Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);

        }
        int ret=0;
        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i]-1)){
                int cur=nums[i];
                int count=1;
                while(set.contains(cur+1)){
                    cur++;
                    count++;
                }
                ret=Math.max(ret,count);
            }

        }
        return ret;

    }

}
