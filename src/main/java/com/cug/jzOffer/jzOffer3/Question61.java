package com.cug.jzOffer.jzOffer3;

import java.util.Arrays;

public class Question61 {
    //扑克牌顺子

    public boolean isContinuous(int [] numbers) {
        if(numbers.length==0)
            return false;
        Arrays.sort(numbers);
        int count=0;
        for (int i = 0; i <numbers.length ; i++) {
            if(numbers[i]==0)
                count++;

        }
        for (int i = count+1; i <numbers.length; i++) {
            int def = numbers[i] - numbers[i - 1];
            if(def>1)
                count-=(def-1);
            else if(def==0)
                return false;
            if(count<0)
                return false;
        }
        if(count>=0)
            return true;
        return false;
    }
}
