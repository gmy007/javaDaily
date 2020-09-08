package com.cug.sort;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeSort {
    public static void main(String[] args) {
        int[] a={-2,1,5,2,3,10,5179,-59,254,-5,-73,2543};
        //sort(a,0,a.length-1);
        mergesort(a,0,a.length-1);

        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
        PriorityQueue<Integer> objects = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }
    public static void mergesort(int[] nums,int l,int r){
        if(l>=r)
            return;
        int mid=(l+r)>>1;
        mergesort(nums,l,mid);
        mergesort(nums,mid+1,r);
        mergeSort(nums,l,mid,r);
    }
    public static void mergeSort(int[] nums,int l,int mid,int r){
        int[] temp=new int[r-l+1];
        int i=l,j=mid+1,k=0;
        while(i<=mid &&j<=r){
            if(nums[i]>nums[j])
                temp[k++]=nums[j++];
            else temp[k++]=nums[i++];
        }
        //两合并数组有剩余
        while (i<=mid)
            temp[k++]=nums[i++];
        while (j<=r)
            temp[k++]=nums[j++];

        for (int m = 0; m <k ; m++) {
            nums[l+m]=temp[m];
        }
    }


    /*
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        //初始化，i指向左半部分的起始；j指向右半部分其实索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            //
            if (i > mid) {
                //左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                //右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - i]) < 0) {
                //左半部分所指元素<右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r)
            return;
        int mid = (r + l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
        */
}
