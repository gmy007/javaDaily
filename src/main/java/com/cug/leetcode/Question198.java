package com.cug.leetcode;

public class Question198 {
    Integer[] memo;
    public int rob(int[] nums) {
        int length = nums.length;
        memo=new Integer[length];
        memo[length-1]=nums[length-1];//最后一个数只能抢劫最后一个房子
        //注意memo的定义，memo[i]是从第i抢到第N-1个房子
        for (int i = length-2; i >=0 ; i--) {
            for (int j = i; j <length ; j++) {
                memo[i]=Math.max(memo[i],nums[j] + (j+2 < length?nums[j+2] : 0));

            }

        }
        return memo[0];

        //return tryRob(nums,0);//递归记忆化


    }

    public int tryRob(int[] nums ,int index){
        //递归
        if(index>=nums.length)
            return 0;
        int res=0;
        if(memo[index]!=null)
            return memo[index];

        for (int i = index; i <nums.length ; i++) {
            res=Math.max(res,nums[i] + tryRob(nums,i+2));

        }
        memo[index]=res;//记忆化
        return res;
    }

}
