package com.cug.jzOffer.jzOffer3;

public class Question64 {
    public int sum(int n){
        int sum=n;
        boolean b=(n>0)&&((sum+=sum(n-1))>0);
        return sum;
    }
}
