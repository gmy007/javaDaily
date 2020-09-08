package com.cug.jzOffer.jianzhiOffer2;

public class Question49 {
    //丑数
    public static void main(String[] args) {
        Question49 q = new Question49();
        int ret = q.GetUglyNumber_Solution(7);
        System.out.println(ret);
    }
    public int GetUglyNumber_Solution(int index) {
        if(index<=6)
            return index;
        int i2=0,i3=0,i5=0;
        int[] dp=new int[index];
        dp[0]=1;
        for (int i = 1; i <index ; i++) {
            int next2=dp[i2]*2,next3=dp[i3]*3,next5=dp[i5]*5;
            dp[i]=min(next2,next3,next5);
            if(dp[i]==next2)
                i2++;
            if(dp[i]==next3)
                i3++;
            if(dp[i]==next5)
                i5++;
        }
        return dp[index-1];
    }
    public int min(int a,int b,int c){
        int min=a<=b?a:b;
        min=min<=c?min:c;
        return min;
    }
}
