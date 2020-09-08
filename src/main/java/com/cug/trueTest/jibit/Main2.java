package com.cug.trueTest.jibit;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        for (int i = 0; i <n ; i++) {
            if(isPrimeNum(n-i)) {
                System.out.println(i);
                break;
            }
            if(isPrimeNum(n+i)) {
                System.out.println(i);
                break;
            }
        }
    }
    public static boolean isPrimeNum(int n) {
        for (int i = 2; i < n; i++) {
            if (n%i==0) {
                return false;
            }
        }
        return true;
    }
}
