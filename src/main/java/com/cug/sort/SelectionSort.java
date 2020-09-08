package com.cug.sort;

public class SelectionSort {
    public void selectSort(int[] nums){
        int length = nums.length;
        for (int i = 0; i <length-1 ; i++) {
            int min=i;
            for (int j = i+1; j <length ; j++) {
                if(nums[min]>nums[j])
                    min=j;
            }
            if(min!=i){
                int temp=nums[i];
                nums[i]=nums[min];
                nums[min]=temp;
            }

        }
    }
}
