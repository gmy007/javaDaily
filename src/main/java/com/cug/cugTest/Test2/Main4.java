package com.cug.cugTest.Test2;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a=new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j]=sc.nextInt();
            }
        }
        int[]minTail = new int[n];
        int len=0;
        Arrays.sort(a,((o1, o2) -> {
            return o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0];
        }));
        for (int i = 0; i <n ; i++) {
            //这里用到了java自带的二分查找法，当然可以自己写，int binarySearch(int []arr,int s, int e, int key )。左闭右开。该方法要求数组非严格单调增。
            //该方法自动查找到数组中第一个等于key的值的索引（假设arr中有key），返回该索引；如果没有则会找到第一个大于key的值的索引x。并返回: - x - 1。
            //若数组中元素均小于key则返回: - len - 1。也就是可以利用返回值找到一个大于或等于key的值的索引。
            int r=Arrays.binarySearch(minTail,0,len,a[i][1]);
            if(r<0)
                r=-r-1;
            if(r==len)
                len++;
            minTail[r]=a[i][1];
        }
        System.out.println(len);
    }
}
