package com.cug.demo0313;

public class QuickSort {
    public static void main(String[] args) {
        int[] a={-2,1,5,2,3};
        quick(a,0,a.length-1);
        //System.currentTimeMillis();
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }

    }
    public static void quick(int[] nums,int low,int high){

        int cur=nums[low];
        int i=low,j=high;
        while(i<j){
            while(i<j&&nums[j]>cur)
                j--;
            while(i<j&&nums[i]<cur)
                i++;
            if(nums[j]==nums[i]&&i<j)
                i++;
            else {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        if(i-1>low)quick(nums,low,i-1);
        if(i+1<high) quick(nums,i+1,high);
    }

    public void quick2(int[] nums,int low,int high){

        int cur=nums[low];
        int i=low,j=high;
        while(i<j){
            while(i<j&&nums[j]>cur)
                j--;
            while(i<j && nums[i]<cur)
                i++;
            if(i<j&&nums[i]==nums[j])
                i++;
            else {
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
            }

        }
        if(i-1>low)quick2(nums,low,i-1);
        if(i+1<high)quick2(nums,i+1,high);
    }
}
