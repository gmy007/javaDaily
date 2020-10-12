package com.cug.qiuzhao.kedaxunfei;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        resolvePrime(n);
    }
    public static void resolvePrime(int num){
        for (int i = 2; i <=num; i++) {
            if(num%i==0 && i!=num){
                System.out.print(i+"*");
                resolvePrime(num/i);
                return;
            }
            if(num==i){
                System.out.print(i);
            }
        }
    }
}
