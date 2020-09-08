package com.cug.leetcode.mianshijindian;

public class demo9 {
    /**
     *
     *字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
     * 输入：s1 = "waterbottle", s2 = "erbottlewat"
     * 输出：True
     * 输入：s1 = "aa", "aba"
     * 输出：False
     */
    public static void main(String[] args) {
        System.out.println("".length());
        isFlipedString("waterbottle","bottlewater");
    }
    public boolean percentSolution(String s1, String s2) {
        if(s1.length()!=s2.length())return false;
        if(s1.equals(s2))return true;
        s1+=s1;
        return s1.contains(s2);

    }
    public static boolean isFlipedString(String s1, String s2) {
        if(s1.length()==0&& s2.length()==0)
            return true;
        if(s1==null||s2==null)
            return false;
        if(s1.length()!=s2.length())
            return false;
        for (int i = 0; i < s1.length(); i++) {
            char c=s1.charAt(i);
            for (int j = 0; j < s2.length(); j++) {
                if(c==s2.charAt(j)){
                    StringBuilder sb = new StringBuilder();
                    sb.append(s2.substring(j,s2.length())).append(s2.substring(0,j));
                    if(s1.equals(sb.toString()))
                        return true;
                }

            }

        }
        return false;
    }
}
