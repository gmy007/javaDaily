package com.cug.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] a={9,4,6,8,1,0,3,7,13,4};
        qu2(a,0,a.length-1);
        //System.currentTimeMillis();
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }

    }
    public static void quickSort(int[] nums,int low,int high) {

        int cur=nums[low];
        int i=low,j=high;
        while (i < j) {
            while(j>i && nums[j]>cur)
                j--;
            while(i<j && nums[i]<cur)
                i++;
            if(nums[i]==nums[j] &&i<j)
                i++;
            else {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        if(i-1>low)quickSort(nums,low,i-1);
        if(j+1<high)quickSort(nums,j+1,high);


    }
    public static void qu2(int[] nums,int low,int high){
       int cur=nums[low];
       int i=low,j=high;
       while(i<j){
           while(i<j&&nums[j]>cur)
               j--;
           while(i<j&&nums[i]<cur)
               i++;
           if(nums[i]==nums[j]&&i<j){
               i++;
           }else {
               int temp=nums[i];
               nums[i]=nums[j];
               nums[j]=temp;
           }
       }
       if(i-1>low)qu2(nums,low,i-1);
       if(j+1<high)qu2(nums,j+1,high);

    }
}
