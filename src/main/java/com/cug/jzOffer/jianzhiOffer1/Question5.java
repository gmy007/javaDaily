package com.cug.jzOffer.jianzhiOffer1;

public class Question5 {
    public String replaceSpace(StringBuffer str) {


        while(str.indexOf(" ")!=-1){
            int num=str.indexOf(" ");
            str.delete(num,num+1);
            str.insert(num,"%20");

        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer s=new StringBuffer();
        s.append("abc a c");

        System.out.println(s.indexOf(" "));

        String s1 = new Question5().replaceSpace(s);
        System.out.println(s1);
    }
}
