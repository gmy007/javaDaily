package com.cug.leetcode;

public class Demo7 {
    public int reverse(int x) {
        int ret = 0;
        while(x!=0){
            int temp = x%10;
            if(ret > Integer.MAX_VALUE/10 || (ret ==Integer.MAX_VALUE && temp>7))
                return 0;
            if(ret < Integer.MIN_VALUE/10 || (ret ==Integer.MIN_VALUE && temp>8))
                return 0;
            ret = ret * 10 +temp;
            x/=10;
        }
        return ret;

    }
}
