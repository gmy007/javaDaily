package com.cug.trueTest.qiniuyun;

import java.util.Scanner;

public class Main2
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b=sc.nextInt();
        int[] grades = new int[n];
        for (int i = 0; i <n ; i++) {
            grades[i]=sc.nextInt();
        }
        int ret=0;
        for (int i = 0; i < n; i++) {
            if(grades[i]>=b)
                ret++;
            int count=grades[i];
            for (int j = i+1; j <n ; j++) {
                count+=grades[j];
                int avg=count/(j-i+1);
                if(avg>=b)
                    ret++;
            }
        }
        System.out.println(ret);
    }
}
