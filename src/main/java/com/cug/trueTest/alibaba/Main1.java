package com.cug.trueTest.alibaba;

import java.util.Scanner;

public class Main1 {
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M=1000000007;
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            System.out.println(func1(n));
        }

    }
    private static long fastPow2(int n){
        if(n==0) return 1;
        if(n==1) return 2;
        long ans=1;
        long base=2;
        while(n!=0){
            if((n&1)==1) ans=((ans%M)*(base%M))%M;
            base=((base%M)*(base%M))%M;
            n>>=1;
        }
        return ans%M;
    }
    //n*2^(n-1) % 1000000007
    private static int func1(int n){
        return (int) (((n%M)*(fastPow2(n-1)%M))%M);
    }
}
