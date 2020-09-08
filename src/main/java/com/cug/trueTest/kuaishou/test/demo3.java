package com.cug.trueTest.kuaishou.test;

import java.util.Scanner;

public class demo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String[][] str=new String[n][2];
        for (int i = 0; i < n; i++) {
            str[i][0]=sc.next();
            str[i][1]=sc.next();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(IsUpdate(str[i][0].trim().split("\\."),str[i][1].trim().split("\\.")));
        }
    }

    private static boolean IsUpdate(String[] str1, String[] str2) {
        int max=Math.max(str1.length,str2.length);
        int[] a=new int[max];
        int[] b=new int[max];
        for (int i = 0; i < max; i++) {
            if(i>str1.length)
                a[i]=0;
            else a[i]=Integer.parseInt(str1[i]);
            if(i>str2.length)
                b[i]=0;
            else b[i]=Integer.parseInt(str2[i]);
        }
        return compareUpdate(a,b,max);
    }

    private static boolean compareUpdate(int[] a, int[] b,int max) {
        for (int i = 0; i < max; i++) {
            if(a[i]<b[i])
                return true;
            if(a[i]>b[i])
                return false;
        }
        return false;
    }
}
