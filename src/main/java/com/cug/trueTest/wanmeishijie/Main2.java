package com.cug.trueTest.wanmeishijie;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[][] nums=new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                nums[i][j]=sc.nextInt();
            }
        }
        Arrays.sort(nums,(o1, o2)-> o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0]);
        int[] minTail=new int[n];
        int len=0;
        for (int[] person : nums) {
            int i = Arrays.binarySearch(minTail, 0, len, person[1]);
            if(i<0)
                i=-i-1;
            minTail[i]=person[1];
            if(i==len)
                len++;
        }
        System.out.println(len);
    }
}
