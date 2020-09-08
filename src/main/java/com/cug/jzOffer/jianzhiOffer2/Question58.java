package com.cug.jzOffer.jianzhiOffer2;

public class Question58 {
    public static void main(String[] args) {
        String a="I AM A STUDENT.";
        String s = ReverseSentence(a);
         //System.out.println(a.substring(0,3));
        System.out.println(s);
//        StringBuilder sb = new StringBuilder();
//        sb.append(a);
//        sb.delete(0,a.length());
//        sb.append(1);
//        System.out.println(sb);
//        System.out.println(a.charAt(0)=='I');
    }
    public static String ReverseSentence(String str) {
        String reverse = new StringBuilder().append(str).reverse().toString();
        char[] chars = reverse.toCharArray();
        StringBuilder sb = new StringBuilder();
        int last=-1;
        for (int i = 0; i <chars.length ; i++) {
            if(chars[i]==' ') {
                String substring = reverse.substring(last+1, i);
                last=i;
                String s = new StringBuilder().append(substring).reverse().append(" ").toString();
                sb.append(s);
            }
        }
        String s = new StringBuilder().append(reverse.substring(last, reverse.length())).reverse().toString();
        return sb.append(s).toString();

    }
}
