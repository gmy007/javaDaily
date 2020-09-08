package com.cug.trueTest.baidu;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            long[] a = new long[n];
            for(int i=0;i<n;i++){
                a[i] = in.nextLong();
            }
            Arrays.sort(a);
            if(a[n-1]<n){
                System.out.println(0);
                continue;
            }
            long num = n;
            long count = 0;
            while (a[n-1]>=n){
                count = count + a[n-1]/num;
                for(int i=0;i<n-1;i++){
                    a[i] = a[i] + a[n-1]/num;
                }
                a[n-1] = a[n-1]%num;
                Arrays.sort(a);
            }
            System.out.println(count);
        }
    }

}
