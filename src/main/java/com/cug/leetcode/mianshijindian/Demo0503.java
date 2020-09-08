package com.cug.leetcode.mianshijindian;

public class Demo0503 {
    public int reverseBits(int num) {
        int i=0;
        int count =0;
        boolean flag=false;
        int prev=0;
        int max=0;
        while(i<=31){
            int cur = num>>i&1;

            if(cur == 1)
                count++;
            else if(!flag){
                flag=true;
                count++;
                prev=i;
            }else {
                i=prev;
                count=0;
                flag=false;
            }
            i++;
            if(count>max)
                max=count;
        }
        return max;

    }
}
