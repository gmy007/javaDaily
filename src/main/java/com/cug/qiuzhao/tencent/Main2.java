package com.cug.qiuzhao.tencent;

import jdk.nashorn.internal.ir.CallNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashSet<Integer> sets = new HashSet<>();
        boolean[] bool = new boolean[m];
        ArrayList<int[]> lists = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int member = sc.nextInt();
            int[] curInts = new int[member];
            for (int j = 0; j < member; j++) {
                curInts[j]=sc.nextInt();
                if(curInts[j] == 0){
                    bool[i]=true;
                }
            }
            lists.add(curInts);
        }
        for (int i = 0; i < m; i++) {
            if(bool[i]){
                int[] curInts = lists.get(i);
                for (int j = 0; j < curInts.length; j++) {
                    sets.add(curInts[j]);
                }
            }
        }
        int preSize = sets.size();
        int lastSize = preSize;
        do {
            for (int i = 0; i < m; i++) {
                if(bool[i])
                    continue;
                int[] curInts = lists.get(i);

                for (int j = 0; j < curInts.length; j++) {
                    if(sets.contains(curInts[j])){
                        bool[i]=true;
                        for (int k = 0; k < curInts.length; k++) {
                            sets.add(curInts[k]);
                        }
                        break;
                    }
                }
            }
            preSize = lastSize;
            lastSize = sets.size();
        }while(preSize!=lastSize);
        System.out.println(lastSize);
    }
}
