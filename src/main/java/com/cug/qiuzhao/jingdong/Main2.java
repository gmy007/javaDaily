package com.cug.qiuzhao.jingdong;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][2 * n - 1];
        int str = (2 * n - 1) / 2;
        long max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = str - i; j <= str + i; j++) {
                nums[i][j] += sc.nextInt();
            }
        }
        System.out.println(getGrade(nums,n));
    }

    public static int getGrade(int[][] nums, int n) {
        int str = (2 * n - 1) / 2;
        int max = 0;
        for (int i = 1; i < n ; i++) {
            for (int j = str - i; j <= str + i; j++) {
                int cur = nums[i][j];
                if(j-1>=0)
                    nums[i][j] = Math.max(cur + nums[i - 1][j - 1],cur + nums[i-1][j]);
                if(j+1<n)
                    nums[i][j]=Math.max(nums[i][j], cur + nums[i - 1][j + 1]);
                if(i == n-1){
                    max = Math.max(nums[i][j],max);
                }
            }
        }
        return max;
    }
}
