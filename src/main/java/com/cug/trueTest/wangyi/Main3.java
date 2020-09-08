package com.cug.trueTest.wangyi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt(),f=sc.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> cur = new ArrayList<>();
            int q=sc.nextInt();
            for (int j = 0; j <q ; j++) {
                cur.add(sc.nextInt());
            }
            list.add(cur);
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(f);
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> cur = list.get(i);
            boolean b=false;
            for (int j = 0; j < cur.size(); j++) {
                if(set.contains(cur.get(j)))
                {   b=true;
                    break;
                }
            }
            if(b){
                for (int j = 0; j < cur.size(); j++) {
                    if(!set.contains(cur.get(j)))
                        set.add(cur.get(j));
                }
            }

        }
        System.out.println(set.size());
    }
}
