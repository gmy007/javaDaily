package com.cug.leetcode;

import java.util.Arrays;

public class Question300 {
    Integer[] memo;

    public static void main(String[] args) {
        Question300 q = new Question300();
        int[] nums ={10,9,2,5,3,7,101,18};
        int i = q.lengthOfLIS(nums);
        System.out.println(i);
    }
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0||nums==null)
            return 0;
        memo = new Integer[nums.length];
        memo[0]=1;
        return trylengthOfLIS(nums,nums.length-1);
    }

    private int  trylengthOfLIS(int[] nums,int index) {

        if(index<0)
            return 0;
        if(memo[index]!=null)
            return memo[index];
        int max=Integer.MIN_VALUE;
        for (int i = index-1; i >=0 ; i--) {
            if(nums[index]>nums[i])
                max=Math.max(max,1+trylengthOfLIS(nums,i));

        }
        memo[index]=max==Integer.MIN_VALUE?1:max;
        return memo[index];//未写完
    }

    private  int dpLengthOfLIS(int[] nums){
        if(nums.length==0)
            return 0;
        memo= new Integer[nums.length];
        Arrays.fill(memo,1);
        for (int i = 1; i <nums.length ; i++) {
            for (int j = 0; j <i ; j++) {
                if(nums[i]>nums[j])
                    memo[i]=Math.max(memo[i],1+memo[j]);
                
            }
        }
        int res=1;
        for (int i = 0; i <nums.length ; i++) {
            res=Math.max(res,memo[i]);
            
        }
        return res;
    }

}
