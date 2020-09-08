package com.cug.leetcode.mianshijindian;

import java.util.Arrays;

public class Demo08_13 {
    /**
     *三维的信封问题。有长宽高三个维度
     * 解法不用二分法
     */
    public int pileBox(int[][] box) {
        int[] dp=new int[box.length];
        Arrays.sort(box,(o1,o2)->o1[0]==o2[0]?o1[1]==o2[1]?o2[2]-o1[2]:o2[1]-o1[1]:o1[0]-o2[0]);
        //对长进行正序排列，长相等则宽高逆序排列，这样的好处是可以省去长的条件
        dp[0]=box[0][2];
        int res=dp[0];
        for (int i = 1; i <box.length ; i++) {
            int max=0,curWid=box[i][1],curHei=box[i][2];
            for (int j = 0; j < i; j++) {
                if(curWid>box[j][1]&&curHei>box[j][2])
                    max=Math.max(max,dp[j]);
            }
            dp[i]=max+curHei;
            res=Math.max(res,dp[i]);
        }
        return res;

    }
}
