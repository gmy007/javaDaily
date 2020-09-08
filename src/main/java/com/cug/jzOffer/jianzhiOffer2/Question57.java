package com.cug.jzOffer.jianzhiOffer2;

import java.util.ArrayList;

public class Question57 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {

        int i=0,j=array.length-1;
        ArrayList<Integer> ret=new ArrayList<>();
        if(array==null||array.length==0)
            return ret;
        while(i!=j){
            if(array[i]+array[j]==sum)
            {
                ret.add(array[i]);
                ret.add(array[j]);
                return ret;
            }else if(array[i]+array[j]>sum)
                j--;
            else i++;
        }
        return ret;
    }
}
