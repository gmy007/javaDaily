package com.cug.jzOffer.jianzhiOffer1;

public class Question4 {
    public boolean Find(int target, int [][] array) {

        if(array==null || array.length==0 || array[0].length==0)
            return false;
        int r=0,c=array[0].length-1;
        while(r<array.length && c>=0){
            if(array[r][c]==target)
                return true;
            else if(array[r][c]>target)
                c--;
            else
                r++;
        }
        return false;
    }
}
