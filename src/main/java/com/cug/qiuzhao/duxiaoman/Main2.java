package com.cug.qiuzhao.duxiaoman;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] chars= new char[n][m];
            int x=-1;
            int y =-1;
            for (int i = 0; i < n; i++) {
                chars[i]=sc.next().toCharArray();
            }
            System.out.println(walkOut(chars));
        }
    }
    static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
    static int walkOut(char[][] chars){
        int n = chars.length;
        int m = chars[0].length;
        int[][] dp = new int[n][m];
        int[] temp = new int[m];
        Arrays.fill(temp,Integer.MAX_VALUE);
        Arrays.fill(dp,temp);
        int x=0,y=0;
        boolean[][] flag = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur =Integer.MAX_VALUE;
                if(chars[i][j] =='#')
                    continue;
                if(chars[i][j]=='@'){
                    x=i;
                    y=j;
                }
                for (int k = 0; k < 4; k++) {
                    int row = i+move[k][0];
                    int col = j+move[k][1];
                    if(row <0 || col<0 || row>=n || col>=m){
                        if(chars[i][j]=='.')
                            dp[i][j]=0;
                        else
                           dp[i][j]=1;
                        break;
                    }
                    if(chars[i][j] == '*' && dp[row][col]!=Integer.MAX_VALUE)
                        dp[i][j]= Math.min(cur,1+dp[row][col]);
                    else if(chars[i][j]=='.')
                        dp[i][j] = Math.min(cur,dp[row][col]);
                }
            }
        }
        return dp[x][y]==Integer.MAX_VALUE?-1:dp[x][y];
    }
}
