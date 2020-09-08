package com.cug.trueTest.kuaishou;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt(),a=sc.nextInt(),b=sc.nextInt();
        int[][] energy=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                energy[i][j]=sc.nextInt();
            }
        }
        int sum=n/a*(m/b);

    }
}
