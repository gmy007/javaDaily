package com.cug.leetcode;

public class Demo169 {
    public int majorityElement(int[] nums) {
        int vote =0;
        int ret=0;
        for(int num:nums){
            if(vote == 0)
                ret = num;
            if(ret != num)
                vote--;
            else
                vote++;
        }
        return ret;
    }
}
