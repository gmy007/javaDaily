package com.cug.leetcode.mianshijindian;

import java.util.ArrayList;

class demo2 {
    /**
     * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     *
     */
    public boolean CheckPermutation(String s1, String s2) {
        if(s1==null||s2==null||s1.length()!=s2.length())
            return false;
        char[] chars = s1.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            list.add(chars[i]);
        }
        for (int i = 0; i < s2.length(); i++) {
            if(list.contains(s2.charAt(i)))
                list.remove((Character)s2.charAt(i));//注意要强转，否则remove(int) 接受的是int参数的方法
        }
        return  list.size()==0?true:false;
    }

    /*
            双100%
     */
    public boolean CheckPermutation2(String s1, String s2) {
        if(s1==null||s2==null||s1.length()!=s2.length())
            return false;
        int[] array=new int[256];
        for (int i = 0; i < s1.length(); i++) {
            array[s1.charAt(i)]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            array[s2.charAt(i)]--;
        }
        for (int i : array) {
            if(i!=0)
                return false;
        }
        return true;
    }
}
