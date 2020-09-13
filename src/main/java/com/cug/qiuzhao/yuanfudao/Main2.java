package com.cug.qiuzhao.yuanfudao;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while(T-->0){
            String s = sc.nextLine();
            parse(s);
        }
    }
    static String parse(String s){
        String temp = s.trim();
        if(!temp.startsWith("(") || !temp.endsWith(")"))
            return "invalid";
        if(!(temp.charAt(1)=='*' ||temp.charAt(1)=='+'||temp.charAt(1)=='-'))
            return "invalid";
        int pre = s.indexOf("(")+1;
        while(s.charAt(pre)=='*' || s.charAt(pre)=='-' ||s.charAt(pre)=='+'||s.charAt(pre)==' ')
            pre++;
        int last = pre;
        int count = 0;
        while(count ==0 && s.charAt(last)!=' '){
            last++;
            char c = s.charAt(last);
            if(c == '(')
                count++;
            if(c == ')')
                count--;
        }
        String s1 = s.substring(pre,last);
        String s2 = s.substring(last,s.indexOf(")")).trim();
        return "invalid";
    }
}
