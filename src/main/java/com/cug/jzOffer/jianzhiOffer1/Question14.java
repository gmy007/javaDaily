package com.cug.jzOffer.jianzhiOffer1;

public class Question14 {
    public int cutRope(int target) {
        int[] ints = new int[target + 1];
        if (target <= 2)
            return 1;
        if (target <= 3)
            return 2;
        ints[1] = 1;
        ints[2] = 2;
        ints[3] = 3;
        int max = 0;
        for (int i = 4; i <= target; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int p = ints[j] * ints[i - j];
                if (max < p)
                    max = p;
                ints[i] = max;
            }

        }
        max = ints[target];
        return max;//动态规划法 分成子问题从下到上求解
    }


    public int integerBreak(int n){
        int[] memo=new int[n+1];
        memo[1]=1;
        for (int i = 2; i <=n ; i++) {
            for(int j=1;j<=i-1;j++){
                memo[i]=max(memo[i],j*(i-j),j*memo[i-j]);
            }
            
        }
        return memo[n];

    }
    public int max(int a,int b,int c){
        int max=a>b?a:b;
        max=max>c?max:c;
        return max;
    }
}
