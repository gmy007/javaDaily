package com.cug.leetcode;

import java.util.HashSet;

public class Question202 {
    public static void main(String[] args) {
        new Question202().isHappy(19);
    }
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<>();
        set.add(n);
        while(n!=1){
            int ret=0;
            while(n!=0){
                ret=(int)Math.pow(n%10,2)+ret;
                n=n/10;
            }
            if(set.contains(ret))
                return false;
            if(ret==1)
                return true;
            set.add(ret);
            n=ret;
        }
        return true;
    }
}
