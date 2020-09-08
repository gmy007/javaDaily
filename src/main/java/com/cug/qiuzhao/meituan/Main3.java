package com.cug.qiuzhao.meituan;


import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i]=sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            v[i]=sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            w[v[i]-1]=0;
            System.out.println(getMaxHeight(w, v[i]-1));
        }
    }
    public static int getMaxHeight(int[] w, int idx){
        int left=0;
        int right=0;
        for (int i = 0; i < idx; i++) {
            left+=w[i];
        }
        for (int i = idx+1; i < w.length; i++) {
            right+=w[i];
        }
        return Math.max(left,right);
    }
}
