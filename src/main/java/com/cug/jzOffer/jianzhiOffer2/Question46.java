package com.cug.jzOffer.jianzhiOffer2;

public class Question46 {
    //把数字翻译成字符串，动态规划，判断条件
    public int numDecodings(String s) {
        if(s==null|| s.length()==0)
            return 0;
        //int length = s.length();
//        int[] dp=new int[length+1];
//        dp[0]=1;
//        dp[1]=s.charAt(0)=='0'?0:1;
//        for (int i = 2 ; i <=length; i++) {
//            if(Integer.valueOf(s.substring(i-1,i))!=0)
//                dp[i]+=dp[i-1];
//            if(s.charAt(i-2)=='0')
//                continue;
//            if(Integer.valueOf(s.substring(i-2,i))<=26)
//                dp[i]=dp[i]+dp[i-2];
//
//        }
        int help=1;
        int result=s.charAt(0)=='0'?0:1;
        int ret=0;
        for (int i = 2 ; i <=s.length(); i++) {
            if(Integer.valueOf(s.substring(i-1,i))!=0)
                help=result;
            if(s.charAt(i-2)=='0')
                continue;
            if(Integer.valueOf(s.substring(i-2,i))<=26) {
                result += help;
                result=help;

            }

        }
        return result;
    }
}
