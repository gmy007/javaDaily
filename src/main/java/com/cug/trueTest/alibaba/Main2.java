package com.cug.trueTest.alibaba;

import java.util.Scanner;

public class Main2 {
    static int[] sta=new int[2];
    static int[] fin=new int[2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m=sc.nextInt();
        int[][] ints = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(sc.next().equals("#"))
                    ints[i][j]=1;
                else if(sc.next().equals("S")){
                    sta[0]=i;sta[1]=j;
                }else if(sc.next().equals("E")){
                    fin[0]=i;
                    fin[1]=j;
                }else ints[i][j]=0;
            }
        }
        System.out.println(-1);
    }
    public  static int dfs(int[][] ints,int a,int b){
        if(a==fin[0]&&b==fin[1]){
            return 1;
        }
        return 0;
    }
}
