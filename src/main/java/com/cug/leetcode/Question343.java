package com.cug.leetcode;

public class Question343 {
    /*
    剪绳子，整数拆分
     */
    int[] memo;
    public int integerBreak(int n) {
        memo=new int[n+1];
        return iB(n);
    }
    public int iB(int n){
        if(n==1)
            return 1;
        int res=-1;
        if(memo[n]!=0)
            return memo[n];
        for (int i = 1; i <=n-1 ; i++) {
            res=max(res,i*(n-i),i*iB(n-i));

        }
        memo[n]=res;
        return res;
    }
    public int max(int a,int b,int c){
        int max=a>b?a:b;
        max=max>c?max:c;
        return max;
    }
}
