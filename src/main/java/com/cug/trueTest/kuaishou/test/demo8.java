package com.cug.trueTest.kuaishou.test;

import java.util.Scanner;

public class demo8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip=sc.next();
        String[] sp1 = ip.split("\\.");
        String[] sp2 = ip.split(":");
        if(sp1.length==4)
            System.out.println(isIp4(ip,sp1));
        else if(sp2.length==8)
            System.out.println(isIp6(ip,sp2));
        else System.out.println("Neither");
    }
    public static  String isIp4(String ip,String[] sp1 ){

        int len = sp1.length;
        for (int i = 0; i < len; i++) {
            if(sp1[i].equals(""))
                return "Neither";
            int num=Integer.parseInt(sp1[i]);
            if(num>255||num<0){
                return "Neither";
            }
            if(sp1[i].charAt(0)=='0')
                return "Neither";
        }
        return "IPv4";
    }
    public static  String isIp6(String ip,String[] split ){
        int len =split.length;
        for (int i = 0; i < len; i++) {
            if(split[i].length()>4||split[i].length()==0)
                return "Neither";
            for (int j = 0; j < split[i].length(); j++) {
                char c=split[i].charAt(j);
                if(!Character.isLetterOrDigit(c))
                    return "Neither";
                
            }
        }
        return "IPv6";

    }


}
