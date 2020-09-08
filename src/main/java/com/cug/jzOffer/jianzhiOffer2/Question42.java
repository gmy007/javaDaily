package com.cug.jzOffer.jianzhiOffer2;

public class Question42 {

    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0)
            return 0;
        int max=Integer.MIN_VALUE;
        int greatestVal=0;
        for(int a:array){
            if(greatestVal<=0)
                greatestVal=a;
            else
                greatestVal+=a;
            if(greatestVal>max)
                max=greatestVal;

        }
        return max;
    }
}
