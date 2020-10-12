package com.cug.qiuzhao.kedaxunfei;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] split = s.split(",");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        System.out.println(maxGift(nums,m,n));
    }

    static int maxGift(int[][] nums,int m,int n){
        int[][] dp = new int[m][n];
        int count = nums[0][0];
        for (int i = 1; i < m; i++) {
            count +=nums[i][0];
            dp[i][0]= count;
        }
        count = nums[0][0];
        for (int i = 1; i < n; i++) {
            count +=nums[0][i];
            dp[0][i]= count;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i-1][j]+nums[i][j],dp[i][j-1]+nums[i][j]);
            }
        }
        return dp[m-1][n-1];
    }
}
