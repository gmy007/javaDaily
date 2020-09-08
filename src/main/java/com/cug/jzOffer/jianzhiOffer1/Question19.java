package com.cug.jzOffer.jianzhiOffer1;

public class Question19 {
    /*
    字符串匹配
     */
    public static void main(String[] args) {

    }
    public boolean match(char[] str, char[] pattern) {

        if (str == null || pattern == null)
            return false;
        int strIndex = 0, patternIndex = 0;
        return match(str, strIndex, pattern, patternIndex);
    }

    public boolean match(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length)
            return true;
        if (strIndex != str.length && patternIndex == pattern.length)
            return false;
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (strIndex != str.length && pattern[patternIndex] == '.')) {
                return match(str, strIndex + 1, pattern, patternIndex)||
                        match(str,strIndex,pattern,patternIndex+2);
            } else {
                return match(str, strIndex, pattern, patternIndex + 2);
            }
        }
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (strIndex != str.length && pattern[patternIndex] == '.'))
            return match(str, strIndex + 1, pattern, patternIndex + 1);
        return false;
    }
}
