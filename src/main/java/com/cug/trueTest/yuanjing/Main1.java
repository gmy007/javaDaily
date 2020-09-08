package com.cug.trueTest.yuanjing;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1=sc.next();
            String s2=sc.next();
            int i=s1.length();
            int j=s2.length();
            System.out.println("1/"+(1+sameDistance(s1,s2,i,j)));
        }

    }
    public static  int sameDistance(String s1,String s2,int len1,int len2){
        int[][] dp=new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <=len2; i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+1);
                dp[i][j]=Math.min(dp[i][j],dp[i][j-1]+1);
            }

        }

        return dp[len1][len2];

    }
}
