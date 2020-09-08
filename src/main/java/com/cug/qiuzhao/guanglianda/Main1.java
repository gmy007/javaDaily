package com.cug.qiuzhao.guanglianda;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.next();
        String s = sc.next();
        System.out.println(getPoint(target,s));
    }
    public static int getPoint(String tar,String cur){
        if(tar==null ||tar.length()==0)
            return 0;
        int ret = 0;
        for (int i = 0; i < tar.length(); i++) {
            if(tar.charAt(i)!= cur.charAt(i))
                ret-=10;
            else
                ret+=20;
            if(ret<0)
                ret=0;
        }
        return ret;
    }

}
