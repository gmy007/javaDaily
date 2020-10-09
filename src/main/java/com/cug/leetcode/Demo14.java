package com.cug.leetcode;

public class Demo14 {
    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length ==0)
            return "";
        String prefix = strs[0];
        int n = strs.length;
        for (int i = 1; i <n ; i++) {
            prefix = longestCommonPrefix(prefix,strs[i]);
            if(prefix.length() == 0)
                return "";
        }
        return prefix;
    }

    private String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(),str2.length());
        int idx = 0;
        while(idx < length && str1.charAt(idx) == str2.charAt(idx) )
            idx++;
        return str1.substring(0,idx);
    }
}
