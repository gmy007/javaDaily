package com.cug.trueTest.meituan;

import java.util.Scanner;
public class Main4{
    //滑动窗口
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int start=0,end=0;
        while (end < str.length()) {
            char c=str.charAt(end);
            start=end+1;
            int pre=end;
            end=str.lastIndexOf(c);
            while(start<end){
                char inner=str.charAt(start);
                end=Math.max(end,str.lastIndexOf(inner));
                start++;
            }
            end++;
            System.out.print(end-pre+" ");

        }


    }

}