package com.cug.leetcode.mianshijindian;

import java.util.HashMap;

public class Demo16_02 {
     HashMap<String, Integer> maps=new HashMap<>();
    public void WordsFrequency(String[] book) {
        for (int i = 0; i < book.length; i++) {
            if(!maps.containsKey(book[i]))
                maps.put(book[i],1);
            else maps.put(book[i],maps.get(book[i])+1);

        }
    }

    public int get(String word) {
        if(maps.containsKey(word))
            return maps.get(word);
        return 0;
    }
}
