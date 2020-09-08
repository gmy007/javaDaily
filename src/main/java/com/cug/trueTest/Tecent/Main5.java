package com.cug.trueTest.Tecent;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        while(n-->0){
            int x=sc.nextInt();
            int k=sc.nextInt();
            int cur=x;
            int dep=0;
            while(cur!=0){
                cur=cur>>1;
                dep++;
            }
            if(dep>k){
                while(dep>k){
                x=x>>1;
                dep--;}
            }else {
                System.out.println(-1);
                continue;}
            System.out.println(x);
        }
    }
}
