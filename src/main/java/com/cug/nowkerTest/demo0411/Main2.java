package com.cug.nowkerTest.demo0411;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n=sc.nextLong(),k=sc.nextLong();
        long count=0;
        if(k == 0){
            System.out.println(n*n);
            return ;
        }
        for (long i = k+1; i <=n ; i++) {
            count+=n/i*(i-k);
            long temp=n%i;
            if(temp>=k){
                count+=temp-k+1;
            }

        }
        System.out.println(count);

    }
}
