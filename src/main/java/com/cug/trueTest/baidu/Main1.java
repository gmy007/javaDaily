package com.cug.trueTest.baidu;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            long n = in.nextInt();
            long a = n;
            long b = n - 1;
            System.out.println(a*b-1);
        }

    }
}
