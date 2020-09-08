package com.cug.qiuzhao.jingdong;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getNum(n));
    }

    public static String getNum(int n){
        int ret = n;
        ArrayList<String> lists = new ArrayList<>();
        lists.add("2");
        lists.add("3");
        lists.add("5");
        if(n<=3)
            return lists.get(n-1);
        n-=3;
        while(n>0){
            for (int i = 0; i < lists.size() ; i++) {
                String cur = lists.get(i);
                lists.add(cur.concat("2"));
                lists.add(cur.concat("3"));
                lists.add(cur.concat("5"));
                n=n-3;
                if(n<=0)
                    break;
            }
        }
        return lists.get(ret-1);
    }
}
