package com.cug.trueTest.kuaishou.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class demo6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] ints = new int[n];
        HashMap<Integer,Integer>[] maps=new HashMap[n];
        for (int i = 0; i < n; i++) {
            ints[i]=sc.nextInt();
            maps[i]=new HashMap<Integer,Integer>();
        }
        if(n<=2)
        {
            System.out.println(n);
            return;
        }
        Arrays.sort(ints);
        int diff=0;
        int max=0;
        for (int i = 1; i <n; i++) {
            for (int j = 0; j <i ; j++) {
                diff=ints[i]-ints[j];
                if(maps[j].containsKey(diff)){
                    maps[i].put(diff,maps[j].get(diff)+1);
                }else {
                    maps[i].put(diff,2);
                }
                max=Math.max(max,maps[i].get(diff));
            }

        }
        System.out.println(max);

    }
}
