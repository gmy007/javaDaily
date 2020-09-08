package com.cug.qiuzhao.meituan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i]=sc.nextInt();
            w[i]=sc.nextInt();
        }
        int[] ret = getMaxValue(v, w, n, m);
        for (int i = 0; i < m; i++) {
            if(i==m-1){
                System.out.println(ret[i]+1);
                break;
            }
            System.out.println(ret[i]+1+" ");
        }
    }

    public static int[] getMaxValue(int[] v, int[] w,int n , int m){
        int[] ret = new int[m];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->{return a[0]-b[0];});
        for (int i = 0; i < n; i++) {
            int cur = 2 * w[i] + v[i];
            if(minHeap.size()>=m){
                if(cur>minHeap.peek()[0]){
                    int[] poll = minHeap.poll();
                    minHeap.add(new int[]{cur,i});

                }
            }else {
                minHeap.add(new int[]{cur,i});
            }

        }
        int i = 0;
        while(!minHeap.isEmpty()){
            ret[i++] = minHeap.poll()[1];
        }
        Arrays.sort(ret);
        return ret;
    }

}
