package com.cug.trueTest.test360;

import java.util.Scanner;

public class Main2 {
    /**
     * A和B两个人在抽奖。现在有一个抽奖箱，里面有n张中奖票，m张不中奖票。A和B轮流从中抽一张奖票出来。如果有人抽到中奖票就结束，抽到中奖票的人胜利。抽过的奖票会被丢弃。
     * 额外的，B每次抽后，会再次抽取一张票并丢弃掉（这张票中奖不算B胜利）。
     * 现在，A先抽，请问A的胜率，保留4位小数后输出。
     * 如果两人到最后也没有抽到中奖票算作B胜利。3
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),m=sc.nextInt();
        double win = win(n, m);
        System.out.println(win);
        System.out.println(String.format("%.4f",win));
    }
    public static  double win(double n,double m){
        if(n<=0)
            return 1;
        if(m<=0)
            return 1;
        double w=n/(n+m);
        if((n+m)<=3)
            return w;
        double l=m/(n+m)*((m-1.0)/(n+m-1.0));
        double a=(m-2.0)/(n+m-2.0);
        double b=n/(n+m-2.0);
        return  w+l*win(n,m-3.0)*a+l*win(n-1.0,m-2.0)*b;
    }
}
