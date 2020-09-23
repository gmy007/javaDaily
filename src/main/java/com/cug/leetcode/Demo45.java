package com.cug.leetcode;

public class Demo45 {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int cur = 0;
        int max = 0;
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > cur) {
                cur = max;
                ret++;
            }
            max = Math.max(max, i + nums[i]);
        }
        return ret;
    }
}
