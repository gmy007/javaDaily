package com.cug.leetcode.mianshijindian;

public class Demo17_16 {
    /**
     * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
     * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
     *
     * 输入： [2,1,4,5,3,1,1,3]
     * 输出： 12
     * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
     *
     *
     */
    public static void main(String[] args) {
        massage(new int[]{1,2,3,1});
    }
    public static int massage(int[] nums) {
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        int[] memo=new int[nums.length];
        memo[0]=nums[0];
        memo[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            memo[i]=Math.max(memo[i-1],memo[i-2]+nums[i]);

        }
        return memo[nums.length-1];
    }

}
