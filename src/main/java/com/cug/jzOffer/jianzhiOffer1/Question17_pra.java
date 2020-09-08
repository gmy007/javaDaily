package com.cug.jzOffer.jianzhiOffer1;

import java.util.Scanner;

public class Question17_pra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        if(n<=0){
            System.out.println(0);
            return;
        }
        char[] chars=new char[n];
        printMaxN(chars,0);

    }
    private static void printMaxN(char[] chars, int digit) {
        if(digit==chars.length){
            printNum(chars);
            return;
        }
        for (int i = 0; i < 10; i++) {
            chars[digit]=(char)(i+'0');//当前digit位，char从0到9
            printMaxN(chars,digit+1);//递归到最深层  第1位是数组第N位
        }
    }

    private static void printNum(char[] chars) {
        int index=0;
        while(index<chars.length&&chars[index]=='0')
            index++;
        while(index<chars.length)
            System.out.print(chars[index++]);
        System.out.println();
    }
}
