package com.cug.qiuzhao.xiaomi;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            int n = s.length();
            if(n <8 || n >120)
                System.out.println(1);
            else {
                char[] chars = s.toCharArray();
                boolean b1=false;
                boolean b2=false;
                boolean b3=false;
                boolean b4=false;
                for (int i = 0; i < n; i++) {
                    if(b1 && b2 && b3 && b4){
                        System.out.println(0);
                        break;}
                    if(!b1 && chars[i] >'a' && chars[i]<'z')
                        b1=true;
                    else if(!b2 && chars[i] >'A' && chars[i]<'Z')
                        b2=true;
                    else if(!b3 && chars[i] >'0' && chars[i]<'9')
                        b3=true;
                    else if(!b4 )
                        b4=true;
                }
                if(!(b1 && b2 && b3 && b4))
                    System.out.println(2);
            }
        }
    }
}
