package com.cug.cugTest.Test2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main2 {
    public ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        ArrayList<String> res = new ArrayList<>();
        res.add(chars.toString());
        for (int i = 0; i < chars.length; i++) {
            for (int j = chars.length-1; j >0; j++) {
                if(chars[j]>chars[j-1]){

                }

            }

        }
        return res;
    }
}
