package com.cug.leetcode.mianshijindian;

public class Demo0501 {
    public int insertBits(int N, int M, int i, int j) {
        int temp = 1<<(j-i+1);
        temp=temp-1;
        temp=temp<<i;
        temp=~temp;
        N=N&temp;
        return N|M;
    }
}
