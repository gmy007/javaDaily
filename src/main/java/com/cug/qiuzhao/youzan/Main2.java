package com.cug.qiuzhao.youzan;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
//        System.out.println(new Main2().minMoves(new int[]{1, 2, 4}));
        System.out.println((int)-2.33333 );
    }


    public int minMoves(int[] nums) {
        // 1 2 
        return 0;
    }


    public static int avg(int[] nums) {
        double ret = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            ret += nums[i] / (double)n;

        }
        return (int) ret;
    }
}
