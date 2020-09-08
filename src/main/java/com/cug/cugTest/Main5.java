package com.cug.cugTest;

import java.util.ArrayList;
import java.util.Scanner;
public class Main5{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] s=new String[n+1];
        for (int i = 0; i <n+1 ; i++) {
            s[i]=sc.nextLine();
        }
        ArrayList<String> arr=new ArrayList<>();
        int count=0;
        int[] counts=new int[n+1];
        counts[0]=0;
        int Max=Integer.MIN_VALUE;
        for (int i = 1; i <n+1 ; i++) {
            String[] cur=s[i].split(" ");
            if("connect".equals(cur[1])){
                count++;
                Max=Math.max(Max,count);
            }else if("disconnect".equals(cur[1])){
                count--;
                Max=Math.max(Max,count);
            }
        }

        if(Max==Integer.MIN_VALUE)
            System.out.println(0);
        else
            System.out.println(Max);

    }
    public static int findMax(int[] a){
        int Max=Integer.MIN_VALUE;
        for (int i = 0; i <a.length; i++) {
            Max=Math.max(Max,a[i]);
        }
        return Max;
    }
/*
6
A connect
A disconnect
B connect
C connect
B disconnect
C disconnect
 */
}
