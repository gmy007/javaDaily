package com.cug.jzOffer.jianzhiOffer2;

import java.util.ArrayList;

public class Question57_1 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> rets=new ArrayList<>();
        if(sum<3)
            return rets;
        int low=1,high=2;
        int mid=(1+sum)/2;
        int count=3;
        while (low<mid){
            if(count==sum){
                ArrayList<Integer> ret = new ArrayList<>();
                for (int i = low; i <=high ; i++)
                    ret.add(i);
                rets.add(ret);
                high++;
                count+=high;
            }else if(count>sum){
                count -=low;
                low++;
            }else {
                high++;
                count+=high;
            }

        }
        return rets;
    }
}
