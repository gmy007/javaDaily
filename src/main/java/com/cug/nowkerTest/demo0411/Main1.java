package com.cug.nowkerTest.demo0411;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt(),M=sc.nextInt();
        int[][] num=new int[N][2];
        for (int i = 0; i < N; i++) {
            num[i][0]=sc.nextInt();
            num[i][1]=sc.nextInt();
        }
        int[] power=new int[M];
        for (int i = 0; i <M ; i++) {
            power[i]=sc.nextInt();
        }
        Arrays.sort(num,(a,b)->a[0]-b[0]);
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for (int i = 1; i < N; i++) {
            num[i][1]=Math.max(num[i-1][1],num[i][1]);
            map.put(num[i-1][0],num[i-1][1]);
        }
        map.put(num[N-1][0],num[N-1][1]);
        for(int i=0;i<M;i++){
            Integer index=map.floorKey(power[i]);
            if(index!=null)
                System.out.println(map.get(index));
            else
                System.out.println(0);
        }
    }
}
