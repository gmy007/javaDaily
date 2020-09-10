package com.cug.leetcode;

public class Knapsack01 {
    /*
    0-1背包问题
     */
    Integer[][] memo;
    public int knapsack01(int[] w, int[] v, int C){
        int n=w.length;
        memo=new Integer[n][C+1];
        return bestValue(w,v,n-1,C);

    }

    private int bestValue(int[] w, int[] v, int index, int c) {
        //递归记忆
        if(index<0 || c<=0)
            return 0;
        if(memo[index][c]!=null)
            return memo[index][c];
        int res=bestValue(w,v,index-1,c);//不放当前index物品
        if(c>=w[index])
            res=Math.max(res,v[index]+bestValue(w,v,index-1,c-w[index]));
        memo[index][c]=res;
        return res;
    }
    private int dpBestValue(int[] w, int[] v,int C){
        int n=w.length;
        if(n==0)
            return 0;
        Integer[][] memo=new Integer[n][C+1];
        for (int j = 0; j <C+1 ; j++) {
            memo[0][j]=(j>=w[0]?v[0]:0);
        }
        /*
        memo[m][n]代表考虑m件物品，n背包容量的可取到的最大价值
        物品
         ↓  0  1  2  3  4 → 剩余容量
         0  0
         1  0
         2  0
         */
        for (int i = 1; i <n ; i++) {
            for (int j = 0; j <C+1 ; j++) {
                memo[i][j]=memo[i-1][j];//不放index物品的价值
                if(j>=w[i])
                    memo[i][j]=Math.max(memo[i][j],v[i]+memo[i-1][j-w[i]]);
                //                                           ↑↑i-1不考虑当前第i个物品，因为已经放进去了
            }

        }
        return memo[n-1][C];
    }
    private int dpBestValueYasuo(int[] w, int[] v,int C){
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
        /*再次压缩
        Integer[] memo=new Integer[C+1];
        for (int j = 0; j <C+1 ; j++) {
            memo[j]=(j>=w[0]?v[0]:0);
        }
        for (int i = 1; i <n ; i++) {
            for (int j = C; j >=0 ; j--) {
              memo[j]=Math.max(memo[j],v[i]+memo[j-w[i]]);
                //
            }

        }
        return memo[C];
         */

    }
    private static int[] P={5,8};
    private static int[] V={5,7};
    private static int T = 10;
    private int[][] dp = new int[P.length + 1][T + 1];
    public void solve3() {
        for (int i = 0; i < P.length; i++){
            for (int j = 0; j <= T; j++){
                for (int k = 0; k * V[i] <= j; k++){
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j-k * V[i]] + k * P[i]);
                }
            }
        }
        System.out.println("最大价值为：" + dp[P.length][T]);
    }
}
