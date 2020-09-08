package com.cug.jzOffer.jianzhiOffer1;

public class Question15 {
    public int NumberOf1(int n) {

        return Integer.bitCount(n);
        //return answer(n);
    }
    public int answer(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
        /*
        这样把一个数减去1，再和原数相与操作，会把这个数二进制形式最右边的1变成0
         */
        
    }
}
