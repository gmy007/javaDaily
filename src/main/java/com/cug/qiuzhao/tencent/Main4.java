package com.cug.qiuzhao.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class Main4
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        for (int i = 0; i < n; i++) {
            int idx = binarySearch(temp,nums[i]);
            if(idx < n/2)
                System.out.println(temp[n/2]);
            else
                System.out.println(temp[n/2-1]);

        }


    }
    public static int binarySearch(int[] arr,int key) {
        int left = 0;
        int right = arr.length;
        int mid;
        while(left <= right) {
            mid = (left + right) / 2;

            if(key < arr[mid]) {
                right = mid - 1;
            }else if(key > arr[mid]) {
                left = mid + 1;
            }else {
                return mid;
            }
        }

        return -1;
    }
}
