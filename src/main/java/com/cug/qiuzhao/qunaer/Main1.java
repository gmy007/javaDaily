package com.cug.qiuzhao.qunaer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        BigDecimal up = multiply(m, n);
        BigDecimal down = jiecheng(n);
        System.out.println(up.divide(down).toString());

    }
    static BigDecimal multiply(int m,int n){
        if(n>m)
            return null;
        BigDecimal x = new BigDecimal(1);
        while(n-->0){
            x = x.multiply(new BigDecimal(m));
            m--;
        }
        return x;
    }
    static BigDecimal jiecheng(int m){
        if(m==0)
            return null;
        BigDecimal x = new BigDecimal(1);
        while(m>1){
            x=x.multiply(new BigDecimal(m));
            m--;
        }
        return x;
    }

}
