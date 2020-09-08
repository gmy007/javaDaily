package com.cug.jzOffer.jianzhiOffer2;

import java.util.Arrays;

public class Question53 {
    //艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹艹
    
    public static void main(String[] args) {
        int[] a={5,7,7,8,8,10};
        System.out.println(Arrays.binarySearch(a,0,a.length,8));
    }
    private class  NewSolution{
        //2020305 leetCode自制二分查找
        public int search(int[] nums, int target) {
            if(nums==null||nums.length==0)
                return 0;
            int countT=binSearch(nums,target,0,nums.length-1);
            if(countT==-1)
                return 0;
            int count=0,t=countT-1;
            while(countT<nums.length&&nums[countT++]==target)
                count++;
            while(t>=0&&nums[t--]==target)
                count++;
            return count;
        }
        public int binSearch(int[] nums,int target,int low,int high){
            if(low==high){
                return nums[low]==target?low:-1;
            }
            int mid=(low+high)>>1;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                return mid-1>=0?binSearch(nums,target,low,mid-1):-1;
            else return mid+1<nums.length?binSearch(nums,target,mid+1,high):-1;
        }
    }
    public static int binSearch(int[] nums,int target,int low,int high){
        if(low==high){
            return nums[low]==target?low:-1;
        }
        int mid=(low+high)>>1;
        if(nums[mid]==target)
            return mid;
        else if(nums[mid]>target)
            return mid-1>=0?binSearch(nums,target,low,mid-1):-1;
        else return mid+1<nums.length?binSearch(nums,target,mid+1,high):-1;
    }
    public int GetNumberOfK(int [] array , int k) {
        if(array==null ||array.length==0)
            return 0;
        int left=getFirstK(array,k,0,array.length-1);
        int right=getLastK(array,k,0,array.length-1);
        if(left!=-1 &&right!=-1)
            return right-left+1;
        return 0;
    }
    public int getFirstK(int[] array,int k,int low,int high){
        while(low<=high){
            int mid=(low+high)>>1;
            if(array[mid]>k)
                high=mid-1;
            else if(array[mid]<k)
                low=mid+1;
            else if((mid>0&& array[mid-1]!=k) ||mid==0)
                return mid;
            else high=mid-1;

        }
        return -1;
    }
    public int getLastK(int[] array,int k,int low,int high){
        while(low<=high){
            int mid=(low+high)>>1;
            if(array[mid]>k)
                high=mid-1;
            else if(array[mid]<k) low=mid+1;
            else if((mid+1<array.length && array[mid+1]!=k)|| mid==array.length-1)
                return mid;
            else low=mid+1;


        }
        return -1;
    }
}
