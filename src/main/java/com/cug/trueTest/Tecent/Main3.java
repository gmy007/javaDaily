package com.cug.trueTest.Tecent;


import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i]=sc.nextInt();
        }

    }
    public static int reverse(int[] a,int[] b,int index,int count){
        if(index==a.length)
            return count;
        int cur=Integer.MAX_VALUE;
        if(a[index]<a[index-1]){
            if(b[index]<b[index-1]){
                int temp=a[index];
                a[index]=b[index-1];
                b[index-1]=temp;
                temp=a[index-1];
                a[index-1]=b[index];
                b[index]=temp;
                if(index-2>=0 ){
                    if(a[index-1]>a[index-2])
                        return reverse(a,b,index+1,count+1);
                    else return -1;
                }
            }else return reverse(a,b,index+1,count);
        }
        return 0;

    }
}
