package com.cug.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Question1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        if(nums.length<k)
            return 0;
        int[] odd = new int[nums.length + 2];
        int size=0;
        odd[0]=-1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%2==1)
                odd[++size]=i;
        }
        int ret=0;
        for (int i = 1; i+k <size ; i++) {
            ret+=(odd[i]-odd[i-1])*(odd[i+k]-odd[i+k-1]);

        }
        return ret;

    }
}
