package com.cug.leetcode.mianshijindian;

public class Demo17_06 {

    /**
     * 编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
     * 例：278
     * dp[0]=8出现2的个数
     * dp[1]=78出现2的个数
     * dp[2]=278中2出现的个数
     *
     * dp[i][1]代表 0到（9…9）i个9出现2的个数  =dp[i-1][1]*10+10^i
     * 第i位是K
     * dp[i]=dp[i-1]+K*dp[i-1][1]+(k==2的情况下，278则加78)n%10^i+(k>2,那么第i位为2出现了10的i次方次)10^i
     */
    class Solution {
        public int numberOf2sInRange(int n) {
            int digit=(int)Math.log10(n)+1;
            int[][] dp=new int[digit][2];
            dp[0][0]=n%10>=2?1:0;
            dp[0][1]=1;//记录0……9  有i-1个9 中2出现的次数

            for (int i = 1; i <digit ; i++) {
                int cur=n/(int)Math.pow(10,i)%10;
                dp[i][0]+=dp[i-1][0];
                dp[i][0]+=dp[i-1][1]*cur;
                if(cur==2)dp[i][0]+=n%(int)Math.pow(10,i);
                if(cur>2)dp[i][0]+=Math.pow(10,i);
                dp[i][1]=(int)Math.pow(10,i)+10*dp[i-1][1];
            }
            return dp[digit-1][0];
        }
    }
}
