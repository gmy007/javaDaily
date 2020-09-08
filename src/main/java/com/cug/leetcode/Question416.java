package com.cug.leetcode;

public class Question416 {
    /*
    给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
    注意:
    每个数组中的元素不会超过 100
    数组的大小不会超过 200

       当做一个背包容量为sum/2的背包问题，不考虑最大价值
     */
    public static void main(String[] args) {
        int[] a={1,5,11,5};
        new Question416().canPartition(a);
    }
    Integer[][] memo;
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n = nums.length;
        for (int i = 0; i <n ; i++) {
            sum+=nums[i];
        }

        if(sum%2==1)
            return false;
        memo=new Integer[n][sum/2+1];
        return tryPartition(nums,n-1,sum/2);
    }

    private boolean tryPartition(int[] nums, int index, int sum) {
        if(sum==0)
            return true;
        if(index<0&&sum>0)
            return false;
        if(sum<0) return false;
        if(memo[index][sum]!=null)
            return memo[index][sum]==1;
        memo[index][sum]=(tryPartition(nums,index-1,sum)
                ||tryPartition(nums,index-1,sum-nums[index]))?1:0;
        return memo[index][sum]==1;

    }

    public boolean dpPartition(int[] nums){
        int sum=0;
        int n = nums.length;
        for (int i = 0; i <n ; i++) {
            sum+=nums[i];
        }

        if(sum%2!=0)
            return false;
        int C=sum/2;
        boolean[] b=new boolean[C+1];
        for (int i = 0; i <=C ; i++) {
            b[i]=(nums[0]==i);
        }//第0个物品是否能填满容量为i的背包
        for (int i = 1; i <n ; i++) {
            for (int j = C; j >=nums[i] ; j--) {
                b[j]=b[j] || b[j-nums[i]];//不用第j个物品能不能填满容量为j的背包或者用第j个物品后，能不能填满容量为j-nums[i]的背包
            }
        }
        return b[C];
    }
}
