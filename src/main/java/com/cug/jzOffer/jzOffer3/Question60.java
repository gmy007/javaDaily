package com.cug.jzOffer.jzOffer3;

public class Question60 {
    Integer[][] memo;

    public static void main(String[] args) {
        Question60 q = new Question60();
        q.probability(2,4);
    }
    public double probability(int n,int s){
        memo=new Integer[n+1][s+1];
        int i = tryProbability(n, s);
        System.out.println(i);
        return 0;

    }
    public int tryProbability(int n,int s){
        if(n<=0||s<=0)
            return 0;
        if(n==1 &&s<=6)
            return 1;
        if(memo[n][s]!=null)
            return memo[n][s];
        int ret=0;
        if(s>1)
            ret+=tryProbability(n-1,s-1);
        if(s>2)
            ret+=tryProbability(n-1,s-2);
        if(s>3)
            ret+=tryProbability(n-1,s-3);
        if(s>4)
            ret+=tryProbability(n-1,s-4);
        if(s>5)
            ret+=tryProbability(n-1,s-5);
        if(s>6)
            ret+=tryProbability(n-1,s-6);
        memo[n][s]=ret;
        return ret;

    }
}
