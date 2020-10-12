package com.cug.qiuzhao.kedaxunfei;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        boolean flag =false;
        int n = s.length();
        int str =0 ,end=n-1;
        while(str<n && s.charAt(str)=='_')str++;
        while(end>=0 && s.charAt(end)=='_')end--;
        s=s.substring(str,end+1);
        n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
            if(s.charAt(i) =='_'){
                while(i<n&&s.charAt(i)=='_')i++;
                i--;
            }
        }
        System.out.println(sb.toString());
    }
}
