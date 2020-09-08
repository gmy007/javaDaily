package com.cug.sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] nums={9,4,6,8,1,0,3,7,13,4};
        mergeSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public  static void quickSort(int[] nums,int low,int high){
        int cur=nums[low];
        int i=low,j=high;
        while(i<j){
            while(i<j&&nums[j]>cur)
                j--;
            while(i<j&&nums[i]<cur)
                i++;
            if(nums[i]==nums[j]&&i<j)
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

    public static void insertSort(int[] nums){

        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j >0; j--) {
                if(nums[j]<nums[j-1]){
                    int temp=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=temp;
                }else break;

            }
        }
    }

    public static void selectionSort(int[] nums ){
        for (int i = 0; i < nums.length; i++) {
            int min=i;
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[j]<nums[min])
                    min=j;
            }
            if(min!=i){
                int temp = nums[i];
                nums[i]=nums[min];
                nums[min]=temp;
            }


        }
    }

    public static void BubbleSort(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i]>nums[j]){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
    }

    public static void mergeSort(int[] nums , int low,int high){
        if(low>=high)
            return;
        int mid=(low+high)>>1;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        mergeSort(nums,low,mid,high);
    }

    private static void mergeSort(int[] nums, int low, int mid, int high) {

        int[] temp=new int[high-low+1];
        int i=low,j=mid+1,k=0;
        while(i<=mid&&j<=high){
            if(nums[i]>nums[j])
                temp[k++]=nums[j++];
            else temp[k++]=nums[i++];
        }
        while(i<=mid){
            temp[k++]=nums[i++];
        }
        while(j<=high){
            temp[k++]=nums[j++];
        }
        for (int l = 0; l <k ; l++) {
            nums[l+low]=temp[l];
        }
    }
}
