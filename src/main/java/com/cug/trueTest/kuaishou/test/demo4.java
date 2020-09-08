package com.cug.trueTest.kuaishou.test;

import java.util.Scanner;

public class demo4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        String[] sp1 = s1.split(" ");
        String[] sp2 = s2.split(" ");
        StringBuilder sb = new StringBuilder();
        int j=0;
        for (int i = 0; i < sp1.length; i++) {

            if(i%4==0&&i!=0&&j<sp2.length){
                sb.append(sp2[j++]).append(" ");
            }
            sb.append(sp1[i]).append(" ");
        }
        while(j<sp2.length){
            if(j==sp2.length-1)
                sb.append(sp2[j++]);
            else
            sb.append(sp2[j++]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
