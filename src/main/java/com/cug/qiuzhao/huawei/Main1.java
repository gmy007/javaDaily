package com.cug.qiuzhao.huawei;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] w = new int[k];
        int[] v = new int[k];
        for (int i = 0; i < k; i++) {
            w[i]=sc.nextInt();
        }
        for (int i = 0; i < k; i++) {
            v[i]=sc.nextInt();
        }
        int N = sc.nextInt();
        int[][] ints = new int[2][N];
        for (int i = 0; i < N; i++) {
            ints[0][i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            ints[1][i] = sc.nextInt();
        }
        System.out.println(getPerfect(w,v,ints));
    }
    public static int getPerfect(int[] w, int[] v,int[][] nums){
        int N = nums[0].length;
        int k = w.length;
        for (int i = 0; i < N; i++) {
            int j = 0;
            while(j<k &&nums[0][i+j] == w[j] && nums[1][i+j] == v[j]){
                j++;
            }
            if(j>=k)
                return i+1;
        }
        return 0;
    }
}
