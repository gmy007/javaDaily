package com.cug.qiuzhao.kedaxunfei;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        String[] split = s.split(",");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
            
        }
        selectSort(nums);
        for (int i = 0; i < n; i++) {
            if(i==n-1)
                System.out.print(nums[i]);
            else
                System.out.print(nums[i]+",");
        }

    }
    public static void selectSort(int[] nums){
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
