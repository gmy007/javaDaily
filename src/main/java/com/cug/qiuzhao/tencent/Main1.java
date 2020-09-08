package com.cug.qiuzhao.tencent;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] link1 = new int[n];
        for (int i = 0; i < n; i++) {
            link1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] link2 = new int[m];
        int pre = 0;
        for (int i = 0; i < m; i++) {
            link2[i] = sc.nextInt();
            int ret = binarySearch(link1, link2[i],pre);
            if(ret!= -1){
                pre = ret;
                System.out.print(link2[i]+" ");
            }
        }

    }
    public static int binarySearch(int[] arr,int key,int left) {
        if(left>=arr.length)
            return -1;
        int right = arr.length;
        int mid;
        while(left <= right) {
            mid = (left + right) / 2;
            if(key > arr[mid]) {
                right = mid - 1;
            }else if(key < arr[mid]) {
                left = mid + 1;
            }else {
                return mid;
            }
        }

        return -1;
    }
}
