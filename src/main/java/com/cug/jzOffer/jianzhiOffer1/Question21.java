package com.cug.jzOffer.jianzhiOffer1;

import java.util.ArrayList;

public class Question21 {
    public void reOrderArray(int [] array) {

        ArrayList<Integer> ji = new ArrayList<>();
        ArrayList<Integer> ou = new ArrayList<>();
        for (int i = 0; i <array.length ; i++) {
            if(array[i]%2==1)
                ji.add(array[i]);
            else ou.add(array[i]);

        }
        int k=0;
        for ( int i = 0; i <ji.size() ; i++) {
            array[k++]=ji.get(i);
        }
        for(int i=0;i<ou.size();i++){
            array[k++]=ou.get(i);
        }
    }
}
