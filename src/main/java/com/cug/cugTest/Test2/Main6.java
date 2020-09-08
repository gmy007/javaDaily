package com.cug.cugTest.Test2;
import java.util.*;
/*
给定一个整型数组arr和一个大于1的整数k。已知arr中只有1个数出现了一次，其他的数出现k次，请返回出现了1次的数。

一个数出现K次，那么在他的K进制下 各个位 分别 连续相加导致进位，肯定会变成0
最后只剩下一个单独出现的数字
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] base = new int[32];//int型 4字节，最多32位
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            int[] kBinary = getKBinaryNum(scanner.nextInt(),k);
            baseAdd(base,kBinary,k);
        }
        System.out.print(getResult(base,k));

    }
    public static int getResult(int[] base,int k){
        int res = 0;
        int m = 1;
        for(int i=31;i>=0;i--){
            res += base[i] * m;
            m *= k;
        }
        return res;
    }


    public static void baseAdd(int[] base,int[] kBinary,int k){
        for(int i=0;i<32;i++){
            base[i] = (base[i]+kBinary[i]) % k;
        }
    }

    public static int[] getKBinaryNum(int num,int k){
        int[] arr = new int[32];
        int index = 31;
        while(index>=0){
            arr[index--] = num % k;
            num = num/k;
        }
        return arr;
    }
}
