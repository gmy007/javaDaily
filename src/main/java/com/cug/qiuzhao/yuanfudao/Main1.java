package com.cug.qiuzhao.yuanfudao;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        m %=3;
        nums = changeNums(nums, m);
        for (int i = 0; i < n; i++) {
            if(i == n-1){
                System.out.print(nums[i]);
                continue;
            }
            System.out.print(nums[i]+" ");
        }
    }
    public static int[] changeNums(int[] nums,int m){
        if(m==0)
            return nums;
        int n = nums.length;
        int[] temp = new int[n];
        int i = 0,j=n/2;
        for (int k = 0; k < n; k++) {
            if(k%2 == 0)
                temp[k]=nums[j++];
            else
                temp[k] = nums[i++];
        }
        return changeNums(temp,m-1);
    }
}
