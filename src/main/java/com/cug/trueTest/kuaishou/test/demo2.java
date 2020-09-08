package com.cug.trueTest.kuaishou.test;

import java.util.ArrayList;
import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr;
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        int[] sup=new int[10];
        for (int i = 0; i < 10; i++) {
            sup[i]=i*i;
        }
        for (int i = 0; i < n; i++) {
            arr = new ArrayList<>();
            System.out.println(IsPow(a[i],sup,arr));
        }
    }
    public static boolean IsPow(int num,int[] sup,ArrayList<Integer> set){
        if(num==1)
            return true;
        if(set.contains(num))
            return false;
        set.add(num);
        int sum=0;
        while(num>0){
            int tmp=num%10;
            sum+=sup[tmp];
            num/=10;
        }
        return IsPow(sum,sup,set);
    }
}
