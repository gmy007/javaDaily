package com.cug.TecentPra.shuqishixi;


import java.util.Scanner;
public class Main1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            String rev=new StringBuffer(s).reverse().toString();
            System.out.println(lcs(s,rev));

        }
        sc.close();
    }
    public static int lcs(String s1,String s2){
        int len=s1.length();
        int[][] dp=new int[len+1][len+1];
        char[] char1=s1.toCharArray();
        char[] char2=s2.toCharArray();
        for(int i=1;i<len+1;i++){
            for(int j=1;j<len+1;j++){
                dp[i][j]=char1[i-1]==char2[j-1]?dp[i-1][j-1]+1:Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return len-dp[len][len];
    }
}
