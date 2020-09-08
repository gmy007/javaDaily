package com.cug.jzOffer.jianzhiOffer2;

public class Question43 {
    public static void main(String[] args) {
        System.out.println(311%10);
    }
    public int NumberOf1Between1AndN_Solution(int n) {
        int cnt=0;
        for (int i = 1; i <=n ; i*=10) {
            int a=n/i;
            int b=n%i;
            cnt=cnt+(a+8)/10*i+(a%10==1?(b+1):0);

        }
        return cnt;
    }
}
