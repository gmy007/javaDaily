package com.cug.trueTest.jibit;

import java.util.Scanner;

public class Main1 {
    static  boolean[] b;
    static int  count=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        char[] str=s.toCharArray();
        int M=sc.nextInt();
        b=new boolean[str.length];
        fun(str,0,new char[str.length],M);
        System.out.println(count);
    }
    public static void fun(char[] str ,int len,char[] newS,int M){

        if(len==str.length)
        {
            int num=Integer.parseInt(new String(newS));
            if((num%M)==0)
                count++;
            return;
        }
        for (int i = 0; i < str.length; i++) {
            if(!b[i]){
                newS[len]=str[i];
                b[i]=true;
                fun(str,len+1,newS,M);
                b[i]=false;
            }
            
        }
    }
}
