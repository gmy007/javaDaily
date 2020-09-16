package com.cug.qiuzhao.didi;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        StringBuffer sb = new StringBuffer();
        StringBuffer ret = new StringBuffer();
        int length = s.length();
        if (n >= length)
            System.out.println(sb.append(s).reverse().toString());
        else if (n==0){
            System.out.println(s);
        }
        else {
            int i = 0;
            for (; i < length; i += n) {
                if (i + n > length)
                    continue;
                sb.append(s.substring(i, i + n));
                ret.append(sb.reverse().toString());
                sb.delete(0, sb.length());
            }
            i = length % n;

            ret.append(sb.append(s.substring(length - i, length)).reverse().toString());
            System.out.println(ret.toString());
        }
    }
}
