package com.cug.leetcode.mianshijindian;

import java.util.Arrays;

public class Demo16_06 {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i=0,j=0;
        long min=Integer.MAX_VALUE;
        while(i<a.length&&j<b.length){
            if(a[i]<b[j]){
                while(i<a.length&&a[i]<b[j])
                    i++;
                if(i<a.length)
                    min=Math.min(min,Math.abs((long)a[i]-b[j]));
                min=Math.min(min,Math.abs((long)a[i-1]-b[j]));
            }else {
                while(j<b.length&&a[i]>b[j])
                    j++;
                if(j<b.length)
                    min=Math.min(min,Math.abs((long)a[i]-b[j]));
                min=Math.min(min,Math.abs((long)a[i]-b[j-1]));
            }
        }
        return (int) min;
    }
}
