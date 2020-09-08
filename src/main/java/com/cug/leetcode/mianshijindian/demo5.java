package com.cug.leetcode.mianshijindian;

public class demo5 {
    public static void main(String[] args) {
        oneEditAway("islander", "slander");
    }

    /**
     * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
     *
     */
    public static boolean oneEditAway(String first, String second) {
        //我的方法，先判断两个字符串长度，长度绝对值大于1肯定不对
        //如果长度一样，那么只有一个不同才可以，如果相差为1，那么跳过一次不同的字串，后面应该都相等。
        int len1 = first.length();
        int len2 = second.length();

        if(Math.abs(len1-len2)>1)
            return false;
        boolean b=false;
        if(len1==len2){

            for (int i = 0; i < len1; i++) {
                if(first.charAt(i)!=second.charAt(i)){
                    if(!b)
                        b=true;
                    else return false;
                }
            }
        }else {
            int i=0,j=0;
            while(i<len1&&j<len2){
                if(first.charAt(i)==second.charAt(j)){
                    i++;j++;
                }else if(!b){
                    b=true;
                    if(len1>len2) i++;
                    if(len2>len1) j++;
                }else return false;

            }
        }
        return true;

    }
}
