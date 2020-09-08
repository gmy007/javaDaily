package com.cug.trueTest.wanmeishijie;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int C=sc.nextInt();
        int[] w=new int[n];
        int[] v=new int[n];
        for (int i = 0; i < n; i++) {
            w[i]=sc.nextInt();

        }
        for (int i = 0; i < n; i++) {
            v[i]=sc.nextInt();

        }
        System.out.println(dpBestValue(w,v,C));
    }
    private static int dpBestValue(int[] w, int[] v,int C){
        int n=w.length;
        if(n==0)
            return 0;
        Integer[][] memo=new Integer[2][C+1];
        for (int j = 0; j <C+1 ; j++) {
            memo[0][j]=(j>=w[0]?v[0]:0);
        }
        for (int i = 1; i <n ; i++) {
            for (int j = 0; j <C+1 ; j++) {
                memo[i%2][j]=memo[(i-1)%2][j];//不放index物品的价值
                if(j>=w[i])
                    memo[i%2][j]=Math.max(memo[i%2][j],v[i]+memo[(i-1)%2][j-w[i]]);

            }

        }
        return memo[(n-1)%2][C];
}
}
