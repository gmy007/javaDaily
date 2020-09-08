package com.cug.jzOffer.jianzhiOffer2;

import java.util.LinkedHashMap;

public class Question50 {
    public static void main(String[] args) {
        Question50 q = new Question50();
        int ret = q.FirstNotRepeatingChar("abcibsdjcauth");
        System.out.println(ret);
    }
    public int FirstNotRepeatingChar(String str) {

        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i <str.length(); i++) {
            char c = str.charAt(i);
            if(!hashMap.containsKey(c))
                hashMap.put(c,1);
            else hashMap.put(c,hashMap.get(c)+1);
        }
        for (int i = 0; i <str.length() ; i++) {
            if(hashMap.get(str.charAt(i))==1)
                return i+1;

        }

        return -1;
    }
}
