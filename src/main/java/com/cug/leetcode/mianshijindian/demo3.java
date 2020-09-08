package com.cug.leetcode.mianshijindian;

public class demo3 {
    /**
     * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，
     * 并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
     *示例1:
     *  输入："Mr John Smith    ", 13
     *  输出："Mr%20John%20Smith"
     * 示例2:
     *  输入："               ", 5
     *  输出："%20%20%20%20%20"
     */
    public String replaceSpaces(String S, int length) {
        return S==null?null:S.substring(0,length).replace(" ","%20");
        /*
        因为已经知道有效长度，把有效长度之后的空格都给截取掉，再用replace
         */
    }
}
