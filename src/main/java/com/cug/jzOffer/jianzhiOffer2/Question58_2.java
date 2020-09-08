package com.cug.jzOffer.jianzhiOffer2;

public class Question58_2 {
    public String LeftRotateString(String str,int n) {
        if(str==null||(n>str.length()))
            return "";
        String pre = str.substring(0, n);
        String last = str.substring(n, str.length());

        StringBuilder sb = new StringBuilder();
        String ret = sb.append(last).append(pre).toString();
        return ret;
    }
}
