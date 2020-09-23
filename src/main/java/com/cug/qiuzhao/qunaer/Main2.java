package com.cug.qiuzhao.qunaer;

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
    static  HashMap<String, Integer> maps;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        String[] s1 = new String[m];
        String[] s2 = new String[m];
        maps = new HashMap<>();
        for (int i = 0; i < m; i++) {
            s1[i]=sc.next();
        }
        for (int i = 0; i < m; i++) {
            s2[i]=sc.next();
            maps.put(s2[i],i);
        }
        System.out.println(longestString(s1,s2));
    }

    /**
     *7
     * b c d e f g a
     * b d a c f g e
     */
    static int finalReview(String[] s1,String[] s2,int idx,int prev){
        int n = s1.length;
        if(idx >= n)
            return 0;
        Integer cur = maps.get(s1[idx]);
        if(cur > prev){
            return Math.max(finalReview(s1,s2,idx+1,prev),1+finalReview(s1,s2,idx+1,cur));
        }
        else {
            return finalReview(s1,s2,idx+1,prev);
        }

    }
    static int longestString(String[] s1,String[] s2){
        int n = s1.length;
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=n; j++) {
                if(s1[i - 1].equals(s2[j - 1]))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);

            }

        }
        return dp[n][n];
    }
}
