package com.cug.trueTest.kuaishou;

import java.util.Arrays;

public class Main1 {
    /**
     * 获取队中从前到后每个人与前方身高高于自己的人的最短距离
     * @param height int整型一维数组 队中从前到后每个人与前方身高高于自己的人的最短距离
     * @return int整型一维数组
     */
    public int[] DistanceToHigher (int[] height) {
        // write code here
        int n=height.length;
        int[] ret=new int[n];
        Arrays.fill(ret,0);
        int max=height[0];
        for (int i = 1; i < n; i++) {
            int cur=height[i];
            if(cur>max){
                ret[i]=0;
                continue;
            }
            for (int j = i-1; j >=0 ; j--) {
                if(height[j]>cur){
                    ret[i]=i-j;
                    break;
                }

            }
        }
        return ret;
    }
}
