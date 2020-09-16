package com.cug.leetcode;

import java.util.HashMap;

public class Demo3 {

    public int lengthOfLongestSubstring(String s) {
        if(s.length()<2)
            return s.length();
        HashMap<Character,Integer> maps = new HashMap<>();
        char[] chars = s.toCharArray();
        int ret = 1;
        maps.put(chars[0],0);
        int i =0,j=1;
        while(j < chars.length){
            if(maps.containsKey(chars[j]) && maps.get(chars[j])>=i){
                i = maps.get(chars[j])+1;
                maps.put(chars[j], j);
            }else{
                maps.put(chars[j],j);
                ret = Math.max(ret, j-i+1);
            }
            j++;
        }
        return ret;
    }
}
