package com.cug.leetcode;

public class Question8 {

    public static void main(String[] args) {
        new Question8().myAtoi("   -42");
    }
    public int myAtoi(String str) {
        str=str.trim();
        if((str.charAt(0)>='0' &&str.charAt(0)<='9')|| str.charAt(0)=='+'|| str.charAt(0)=='-'){
            long ret=0;
            boolean neg = str.charAt(0) == '-';
            for (int i = !Character.isDigit(str.charAt(0)) ? 1 : 0; i <str.length() ; i++) {
                if(!Character.isDigit(str.charAt(i)))
                    break;
                ret=ret*10+(str.charAt(0)-'0');
                if(!neg&&ret > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                if(neg && ret<Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }
            return neg?(int)-ret:(int)ret;
        }
        return 0;
    }
}
