package com.cug.trueTest.meituan;

import java.util.Arrays;
import java.util.Scanner;
public class Main3{
    private static int N=0;
    private static  double max=-1;
    private static  int[] result=null;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        double[][] a=new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j]=sc.nextDouble();
            }
        }
        boolean[] b=new boolean[N];
        int[] preRet=new int[N];
        result=new int[N];
        searchMax(a,b,preRet,0,0);

        System.out.println(String.format("%.2f",max));
        for (int i = 0; i <N; i++) {
            System.out.println((i+1)+" "+(result[i]+1));
        }
    }
    private static void searchMax(double[][] a, boolean[] b, int[] preRet,int index,double ret) {
        if(index==N){
            if(ret>max){
                System.arraycopy(preRet,0,result,0,N);
                max=ret;
                return;
            }
            return ;
        }
        for (int i = 0; i < N; i++) {
            if(!b[i]){
                b[i]=true;
                preRet[index]=i;
                searchMax(a,b,preRet,index+1,ret+a[index][i]);
                preRet[index]=-1;
                b[i]=false;
            }
        }
    }
}