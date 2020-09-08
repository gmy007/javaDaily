package com.cug.trueTest.wangyi;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        long[] ls=new long[n-1];
        long pre=sc.nextLong();
        boolean b=false;
        for (int i = 0; i < n-1; i++) {
            long cur=sc.nextLong();
            ls[i]=cur-pre;
            if(ls[i]<=0)
                b=true;
            pre=cur;
        }
        if(b)
            System.out.println(-1);
        else {
            for (int i = 0; i < n-2; i++) {
                long c=gcd(ls[i],ls[i+1]);
                if(c==1){
                    System.out.println(1);
                    break;
                }
                ls[i+1]=c;

            }
            System.out.println(ls[n-2]);
        }
    }

    public static long gcd(long a,long b){
        if(b>a){
            long temp=a;
            a=b;
            b=temp;
        }
        long val=a%b;
        if(val==0)
            return b;
        else return gcd(b,val);
    }
}
