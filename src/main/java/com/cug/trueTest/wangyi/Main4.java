package com.cug.trueTest.wangyi;

import java.util.Scanner;

public class Main4 {
    static int[][] move={{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        int[][] nums=new int[n][m];
        for (int i = 0; i < n; i++) {
            String s=sc.next();
            for (int j = 0; j < m; j++) {
                nums[i][j]=Integer.parseInt( String.valueOf(s.charAt(j)));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(nums[i][j]==0)
                    System.out.print(0+" ");
                else System.out.print(dfs(nums,i,j)+" ");
            }
            System.out.println();
        }
    }
    public static int dfs(int[][] nums, int r,int c){
        if(r>=nums.length||c>=nums[0].length||r<0||c<0)
            return 9999;
        if(nums[r][c]==0)
            return 0;

        int val=Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            val=Math.min(val,1+dfs(nums,r+move[i][0],c+move[i][1]));
        }
        return val;

    }
}
