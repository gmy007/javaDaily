package com.cug.trueTest.meituan0312;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    /**
     * 最好一样
     * 时间限制：C/C++语言 1000MS；其他语言 3000MS
     * 内存限制：C/C++语言 131072KB；其他语言 655360KB
     * 题目描述：
     * 给出一个序列包含n个正整数的序列A，然后给出一个正整数x，你可以对序列进行任意次操作的，每次操作你可以选择序列中的一个数字，让其与x做按位或运算。你的目的是让这个序列中的众数出现的次数最多。
     *
     * 请问众数最多出现多少次。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int[] a=new int[n];

        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();

        }
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            max=Math.max(max,maxCount(a,x,a[i]));
            if(a[i]!=(a[i]|x))
            max=Math.max(max,maxCount(a,x,a[i]|x));
        }
        System.out.println(max);
    }

    public static  int maxCount(int[]a,int x,int now){
        int count=0;
        for (int i = 0; i < a.length; i++) {
            if(a[i]==now||((a[i]|x)==now)){
                count++;
            }
        }
        return count;
    }
}
