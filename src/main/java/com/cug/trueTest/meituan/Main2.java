package com.cug.trueTest.meituan;

import java.util.Scanner;

import java.util.Scanner;
public class Main2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        char[] p=sc.nextLine().toCharArray();
        char[] t=sc.nextLine().toCharArray();
        System.out.println(match(p,t,0,0));

    }
    public static int match(char[] p,char[] t,int p1,int t1){
        if(p1==p.length && t1==t.length)
            return 1;

        if(p1<p.length && t1<t.length && p[p1]=='*'){
            return match(p,t,p1,t1+1)|match(p,t,p1+1,t1)|match(p,t,p1+1,t1+1);
                                                                //如果没有同时向后推的匹配项，在*以末尾结束时导致无法匹配,
                                                                //因为结束条件是p1==p.length &&t1==t.length
        }

        if(p1<p.length && t1<t.length &&(p[p1]==t[t1]||p[p1]=='?'))
            return match(p,t,p1+1,t1+1);
        return 0;
    }
}
