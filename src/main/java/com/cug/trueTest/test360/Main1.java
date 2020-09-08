package com.cug.trueTest.test360;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s1=sc.nextLine().toCharArray();
        char[] s2=sc.nextLine().toCharArray();
        int count1=0,count2=0;
        for (int i = 0; i < s1.length; i++) {
            if(s1[i]=='T'&&s2[i]=='A'){
                count1++;
            }else if(s1[i]=='A'&&s2[i]=='T')
                count2++;
        }
        System.out.println(Math.max(count1,count2));
    }
}
