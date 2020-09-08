package com.cug.qiuzhao.T360;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i]=sc.next();
        }
        System.out.println(refuse(strings));
    }
    public static int refuse(String[] s){
        int ret =0;
        for (int i = 0; i < s.length; i++) {
            if(s[i].length()<=10 &&s[i].matches("[a-z|A-Z]+")){
                ret++;

            }

        }
        return ret;

    }
}
