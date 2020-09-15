package com.cug.leetcode;

public class Demo53 {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int ret = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(nums[i],pre+nums[i]);
            ret= Math.max(ret,pre);
        }
        return ret;
    }
}
