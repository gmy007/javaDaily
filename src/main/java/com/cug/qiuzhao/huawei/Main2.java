package com.cug.qiuzhao.huawei;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(maxShuigou(nums,i,j),max);
            }
        }
        System.out.println(max);


    }
    static int[][] move = {{0,1},{0,-1},{-1,0},{1,0}};
    public  static int maxShuigou(int[][] nums,int x,int y){
        int ret=1 ;
        for (int i = 0; i < 4; i++) {
            int newX = x+move[i][0];
            int newY = y+move[i][1];
            if(newX<0 || newY<0 || newX>=nums.length || newY>=nums[0].length || nums[newX][newY]>=nums[x][y])
                continue;
            ret = Math.max(ret,1+maxShuigou(nums,newX,newY));
        }
        return ret;
    }
}
