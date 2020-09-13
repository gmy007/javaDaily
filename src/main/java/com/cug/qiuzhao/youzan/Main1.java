package com.cug.qiuzhao.youzan;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        System.out.println(new Main1().sum(3, 5));
    }
    public long sum (int num, int itemNum) {
        // write code here
        return doSum(num,itemNum);
    }
    public long doSum(int num , int idx){
        if(idx == 1)
            return num;
        long ret = num;
        int i = idx;
        while(i-- >1)
            ret=ret*10+num;
        return  ret+doSum(num,idx-1);
    }
}
