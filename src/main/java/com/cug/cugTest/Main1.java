package com.cug.cugTest;

import java.util.Scanner;
public class Main1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int count=0;
        while(n!=1){
            if(n%2==1){
                n=(3*n+1)/2;
            }else {
                n/=2;
            }
            count++;
        }
        System.out.print(count);
    }
}
