package com.cug.trueTest.kuaishou.test;

import java.util.Arrays;
import java.util.Scanner;

public class demo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        Arrays.sort(nums);
        int res=nums[n-1];
        for (int i = n-2; i >=0; i--) {
            if(res>0)
                res-=nums[i];
            else res+=nums[i];
        }

        System.out.println(res);
    }
}
