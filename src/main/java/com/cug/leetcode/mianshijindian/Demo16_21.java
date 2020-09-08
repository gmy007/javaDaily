package com.cug.leetcode.mianshijindian;

import java.util.HashSet;

public class Demo16_21 {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1=0,sum2=0;
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : array1) {
            sum1+=i;
            set1.add(i);
        }
        for (int i : array2) {
            sum2+=i;
            set2.add(i);
        }
        if((sum1-sum2)%2!=0)return new int[0];
        int diff=(sum1-sum2)>>1;

        for (int i : array1) {
            if(set2.contains(i-diff))
                return new int[]{i,i-diff};
        }


        return new int[0];
    }
}
