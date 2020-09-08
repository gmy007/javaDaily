package com.cug.trueTest.meituan0312;

import java.util.Scanner;

/**
 * 双行道
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 有一个2*n的网格，有一个人位于(1,1)的位置，即左上角，他希望从左上角走到右下角，即(2,n)的位置。在每一次，他可以进行三种操作中的一种：
 *
 * 1． 向右走一格，即从(x,y)到(x,y+1);
 *
 * 2． 向上右方走一格，即，如果他在(2,y)的位置可以走到(1,y+1);
 *
 * 3． 向下右方走一格，即，如果他在(1,y)的位置可以走到(2,y+1);
 * 问题当然不会这么简单，在这2*n的格子中，有一部分格子上有障碍物，他不能停在障碍物上，当然也不能走出网格，请问他有多少种不同的路线可以到达(2,n)。
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        String s1=sc.next();
        String s2=sc.next();
        char[][] chars=new char[2][n];
        chars[0]=s1.toCharArray();
        chars[1]=s2.toCharArray();
        search(chars,0,0);

        System.out.println(ret==0?-1:ret);
    }
    static int[][] change={{0,1},{-1,1},{1,1}};
    static int ret=0;
    static int n=0;
    public static  void search(char[][] chars,int x,int y){
        if(x==1&&y==n-1&&chars[x][y]=='.'){
            ret++;
            return;
        }
        if(x<0 || y>=n ||x>=2)
            return;
        if(chars[x][y]=='X')
            return;
        for (int[] ints : change) {
            search(chars,x+ints[0],y+ints[1]);
        }
    }
}
