package com.cug.trueTest.jingdong;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[][] st=new int[n][2];
        int max=0;
        for (int i = 0; i <n; i++) {
            st[i][0]=sc.nextInt();
            st[i][1]=sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int l=st[i][0],r=st[i][1];
            int count=1;
            for (int j = 0; j < n; j++) {
                if(j==i||st[j][0]>r ||st[j][1]<l)
                    continue;
                else count++;
            }
            max=Math.max(max,count);
        }
        System.out.println(max);
    }
}
