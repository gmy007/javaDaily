package com.cug.qiuzhao.guanglianda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int C = sc.nextInt()*100;
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = (int)sc.nextDouble()*100;
            v[i] = sc.nextInt();
        }
        System.out.println(knapsack(w,v,C));
    }

    public static int knapsack(int[] w, int[] v, int C) {
        int n = w.length;
        int[][] dp = new int[n][C + 1];
        for (int j = 0; j < C + 1; j++) {

            dp[0][j] = (j >= w[0] ? v[0] : 0);

        }
        for (int i = 1; i <n ; i++) {
            for (int j = 0; j < C+1; j++) {
                dp[i][j]=dp[i-1][j];
                if(j>w[i]){
                    dp[i][j]= Math.max(dp[i][j],dp[i][j-w[i]]+v[i]);
                }
            }
        }
        return dp[n-1][C];

    }
}
