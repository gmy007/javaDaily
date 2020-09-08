package com.cug.nowkerTest;


import java.util.Scanner;

public class Pra1 {
    //在其它数都出现k次的数组中找到只出现一次的数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt();
        int[] base=new int[32];
        for (int i = 0; i < n; i++) {
            int cur=sc.nextInt();
            base = addK(base, getKBinary(cur, k), k);
        }
        System.out.println(getResult(base,k));

    }
    public static  int getResult(int[] ret,int k){
        int count=0;
        int m=1;
        for (int i = 31; i >=0 ; i--) {
            count+=ret[i]*m;
            m*=k;
        }
        return count;
    }
    public static int[] addK(int[] num1,int[] num2,int k){
        int[] ret=new int[32];
        for (int i = 31; i >=0 ; i--) {
            ret[i]=(num1[i]+num2[i])%k;
        }
        return ret;
    }
    public static int[] getKBinary(int num,int k){
        int[] arr=new int[32];

        for (int i = 31; i >=0; i--) {
            arr[i]=num%k;
            num=num/k;
        }
        return arr;
    }
}
