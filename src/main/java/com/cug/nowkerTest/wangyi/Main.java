package com.cug.nowkerTest.wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        long[] longs=new long[n];
        int count=0;
        for (int i = 0; i < n; i++) {
            longs[i]=sc.nextLong();
            if(longs[i]%2==0)
                count++;
        }
        if(!(count==0||count==n))
            Arrays.sort(longs);
        for (int i = 0; i <n ; i++) {
            System.out.print(longs[i]+" ");
        }

        
    }

    public static  void fun2(){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0){
            t--;
            int n=sc.nextInt();
            long max=0,cmax=0,ccmax=0;
            for (int i = 0; i < n; i++) {
                long cur=sc.nextLong();
                if(cur>max){
                    ccmax=cmax;
                    cmax=max;
                    max=cur;
                }
            }
            if(max>(ccmax+cmax))
                System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
