package com.cug.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a={-2,1,5,2,3};
        bubblesort(a);
        System.currentTimeMillis();
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }

    }
    public static void bubblesort(int[] nums){
        int n=nums.length;
        for (int i = 1; i <n ; i++) {
            for (int j = 0; j <n-i ; j++) {
                if(nums[j]>nums[j+1])
                {
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
    }


}
