package com.cug.leetcode;

public class Demo215 {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{-1,-1}, 2));
    }
    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int partition = partition(nums, 0, n - 1);
        if(partition == n-k)
            return nums[partition];
        while(partition != n-k){
            if(partition>n-k)
                partition = partition(nums,0,partition-1);
            else {
                partition = partition(nums,partition+1,n-1);
            }
        }
        return nums[partition];
    }
    public static int partition(int[] nums, int l,int r){
        int cur = nums[l];
        int i=l,j=r;
        while(i<j){
            while(i<j && nums[j]>cur)
                j--;
            while(i<j && nums[i]<cur)
                i++;
            if(nums[i] ==nums[j] &&i<j)
                j--;
            else{
                int temp =nums[i];
                nums[i]=nums[j];
                nums[j]= temp;
            }
        }
        return i;
    }
}
