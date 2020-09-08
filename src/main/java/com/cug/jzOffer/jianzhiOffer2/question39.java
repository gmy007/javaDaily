package com.cug.jzOffer.jianzhiOffer2;

import java.util.Arrays;

public class question39 {
    /*
    超过数组长度一半的数一定在中间
     */
    public int MoreThanHalfNum_Solution(int [] array) {

        if(array.length==0)
            return 0;
        if(array.length==1)
            return array[0];
        Arrays.sort(array);
        int ret=array[array.length/2];
        int count=0;
        for (int i = 0; i <array.length ; i++) {
            if(array[i]==ret)
                count++;

        }
        if(count>(array.length/2))
            return ret;
        else return 0;
    }
}
