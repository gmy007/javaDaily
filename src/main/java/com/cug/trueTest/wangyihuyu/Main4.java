package com.cug.trueTest.wangyihuyu;

import java.util.Arrays;

public class Main4 {
    public static void main(String[] args) {
        int[][] nums={{5,6,3}, {5,4,5}, {6,6,6}};
        System.out.println(pileBox(nums));
    }
    public static int pileBox(int[][] boxes) {
        int[] dp=new int[boxes.length];
        Arrays.sort(boxes,(o1, o2)->o1[0]==o2[0]?o1[1]==o2[1]?o2[2]-o1[2]:o2[1]-o1[1]:o1[0]-o2[0]);
        //对长进行正序排列，长相等则宽高逆序排列，这样的好处是可以省去长的条件
        Arrays.fill(dp,1);
        int res=0;
        for (int i = 1; i <boxes.length ; i++) {
            int curWid=boxes[i][1],curHei=boxes[i][2];
            for (int j = 0; j < i; j++) {
                if(curWid>boxes[j][1]&&curHei>boxes[j][2])
                    dp[i]=Math.max(dp[i],1+dp[j]);
            }
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}
