package com.cug.leetcode.mianshijindian;

import java.util.Arrays;

public class Demo17_08_xinfeng {
    /**
     * 有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。
     * 已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。
     *
     * 二分查找解决最长递增子序列
     * 先对height进行递增排序，height相等的则根据weight递减排序
     * 对weight求最长递增子序列，维护一个最长子序列数组，用二分查找在这个数组中找比遍历到的当前数第一个大的数，替换掉，
     * 或者返回一个-len-1代表数组中都比这个数小，那么返回的值变回len，然后新增一个数
     *
     * 最后返回的mintail数组不一定是最长子序列！
     */
    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        int[] b={87,56,45,55,41};
        bestSeqAtIndex(a,b);

    }
    public static int bestSeqAtIndex(int[] height, int[] weight) {
        int N=height.length;
        int[][] temp=new int[N][2];
        for (int i = 0; i < N; i++) {
            temp[i]=new int[]{height[i],weight[i]};
        }
        Arrays.sort(temp,(o1,o2)-> o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0]);
        int[] minTail=new int[N];
        int len=0;
        for (int[] person : temp) {
            int i = Arrays.binarySearch(minTail, 0, len, person[1]);
            if(i<0)
                i=-i-1;
            minTail[i]=person[1];
            if(i==len)
                len++;
        }
        return len;
    }
}
