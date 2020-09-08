package com.cug.trueTest.wangyihuyu;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    static long ret=0;
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] wi=new int[N];
        int[] ti=new int[N];
        for (int i = 0; i < N; i++) {
            wi[i]=sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            ti[i]=sc.nextInt();
        }
        Arrays.sort(wi);
        Arrays.sort(ti);
        M=sc.nextInt();
        
        fenpei(wi,ti,0,new boolean[N]);
        System.out.println(ret);
    }

    public static void fenpei(int[] wi,int[] ti,int num,boolean[] visit){
        boolean b=false;
        int N = ti.length;
        if(num==N){
            ret=(ret+1)%M;
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!visit[i]&&wi[num]>=ti[i]){
                visit[i]=true;
                b=true;
                fenpei(wi,ti,num+1,visit);
                visit[i]=false;
            }
            if(wi[num]<ti[i])
                break;
        }
        if(!b)
            return;

    }
}
