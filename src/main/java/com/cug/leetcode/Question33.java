package com.cug.leetcode;

public class Question33 {
    public int search(int[] nums, int target) {
        int l=0,h=nums.length-1;
        int mid=(l+h)>>1;
        while(l<=h){
            mid=(l+h)>>1;
            if(nums[mid]==target)return mid;
            if(nums[l]<=nums[mid] )
                if(target<nums[mid] &&target>=nums[l])
                    h=mid-1;
                else l=mid+1;
            else{
                if(target>nums[mid] && target<= nums[h])
                    l=mid+1;
                else h=mid-1;
            }
        }
        return -1;
    }
}
