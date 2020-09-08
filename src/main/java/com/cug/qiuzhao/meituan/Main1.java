package com.cug.qiuzhao.meituan;


import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n>0){
            if(n==1){
                System.out.print(refuse(sc.next()));
                break;
            }
            System.out.println(refuse(sc.next()));
            n--;
        }
    }

    public static String refuse(String s){
        return s.matches("[a-z|A-Z]+[0-9]+")?"Accept":"Wrong";
    }
}
