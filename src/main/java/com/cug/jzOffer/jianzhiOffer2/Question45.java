package com.cug.jzOffer.jianzhiOffer2;

import java.util.Arrays;

public class Question45 {
    //String类型的compareTo方法，自动比较两字符串第一个字符，不同则返回相减值，相同则继续比较。
    public static void main(String[] args) {
        String s1="21";
        String s2="123";
        //System.out.println((s1+s2).compareTo(s2+s1));
        System.out.println(s2.substring(1,2));
    }
    public String PrintMinNumber(int [] numbers) {
        if(numbers.length==0 || numbers==null)
            return "";
        int l=numbers.length;
        String[] s=new String[l];
        for (int i = 0; i <l ; i++) {
            s[i]=String.valueOf(numbers[i]);
        }
        Arrays.sort(s,(s1,s2)->(s1+s2).compareTo(s2+s1));
        StringBuilder sb = new StringBuilder();
        for(String  str:s)
            sb.append(str);
        return sb.toString();
    }
}
