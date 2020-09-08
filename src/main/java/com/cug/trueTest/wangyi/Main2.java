package com.cug.trueTest.wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),D=sc.nextInt();
        int[][] nums=new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0]=sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            nums[i][1]=sc.nextInt();
        }
        Arrays.sort(nums,(a,b)->a[1]==b[1]?b[0]-a[0]:a[1]-b[1]);
        System.out.println();
    }
}
