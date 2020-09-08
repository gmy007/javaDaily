package com.cug.demo;

import java.util.Stack;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static int a=101;
    public static void main(String[] args) {
        String str="www.toutiao.p/hello/index.com";
        StringBuilder sb = new StringBuilder();
        String s = sb.append(str).reverse().toString();
        String[] split = s.split("\\.");
        System.out.println(s);
        sb.delete(0,sb.length());
        for (String s1 : split) {
            String[] split1 = s1.split("/");

            if(split1.length>1)
                for (String s2 : split1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb.append(sb2.append(s2).reverse().append("/").toString());
                }
            else{
                sb.append(new StringBuilder().append(s1).reverse().append(".").toString());
            }
        }
        System.out.println(sb.toString());

    }

    private static void sortByNo1Col() {
        int[][] helper=new int[10][10];
        for (int i = 0; i < helper.length; i++) {
            for (int j = 0; j < helper[0].length; j++) {
                helper[i][j]=new Random().nextInt(100);
            }
        }
        Arrays.sort(helper, Comparator.comparingInt(o -> o[0]));//按第一列排序
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(helper[i][j]+" ");
            }
            System.out.println();


        }
    }
}
