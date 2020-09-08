package com.cug.leetcode.mianshijindian;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class demo4 {
    /**
     * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
     * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
     * 回文串不一定是字典当中的单词。
     *
     * 示例1：
     *输入："tactcoa"
     *输出：true（排列有"tacocat"、"atcocta"，等等）
     */
    public boolean canPermutePalindrome(String s) {
        /*
        当前字符串中字符出现奇数次字符只能有一个
         */

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if(!set.add(s.charAt(i)))
                set.remove(s.charAt(i));

        }
        return set.size()<=1?true:false;
    }
}
