package com.cug.jzOffer.jianzhiOffer1;

public class Question20 {
    public  int index=0;
    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");

    }

    public static void main(String[] args) {
        char[] b ={'+','5','0','0'};

    }
    public  boolean isNumeric2(char[] str){
        boolean flag=false;
        flag=isInteger(str);
        if(index<str.length && str[index]=='.'){
            index++;
            flag=isUnsignedNum(str)||flag;
        }
        if(index<str.length && (str[index]=='e' || str[index]=='E')){
            index++;
            flag=isInteger(str)&&flag;
        }
        return flag && index==str.length;


    }
    public   boolean isInteger(char[] str){
        if(index<str.length && (str[index]=='+' || str[index]=='-'))
            index++;
        return isUnsignedNum(str);

    }
    public  boolean isUnsignedNum(char[] str){
        int start=index;
        while (index<str.length && str[index]>='0' && str[index]<='9'){
            index++;
        }
        return start<index;
    }
}
