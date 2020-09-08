package com.cug.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RadixSort {
    public static void main(String[] args) {
        RadixSort r = new RadixSort();
        int[] a={2,1,5,2,3,10,5179,59,254,5,73,2543};
        r.RadixSort(a);
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }
     public void RadixSort(int[] array){
         int length = array.length;
         //计算最大值的位数
         int max=Integer.MIN_VALUE;
         for (int i = 0; i <length ; i++)
             max=Math.max(max,array[i]);
         int count=0;
         while(max>0){
             count++;
             max=max/10;
         }
         //生成桶
         List<LinkedList<Integer>> buckets=new ArrayList<>();
         for (int i = 0; i <10 ; i++)
             buckets.add(new LinkedList<>());
         //遍历个十百千位
         for (int i = 0; i <count ; i++) {
             for (int j = 0; j <length ; j++) {
                 int key=(int)(array[j]/Math.pow(10,i)%10);
                 buckets.get(key).add(array[j]);
             }
             int newIndex=0;
             for (int j = 0; j <10 ; j++) {

                 while(!buckets.get(j).isEmpty())
                    array[newIndex++]=buckets.get(j).remove(0);

             }
         }

     }
}
