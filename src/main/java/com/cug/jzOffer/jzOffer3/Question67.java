package com.cug.jzOffer.jzOffer3;

public class Question67 {
    public int StrToInt(String str) {
        if(str.length()==0|| str==null)
            return 0;
        boolean isNegative=str.charAt(0)=='-';
        char[] chars = str.toCharArray();
        long ret=0;
        for (int i = 0; i < str.length(); i++) {
            if(i==0&&(chars[i]=='-'||chars[i]=='+'))
                continue;
            if(chars[i]<'0' || chars[i]>'9')
                return 0;
            ret=ret*10+chars[i]-'0';
        }
        ret=isNegative?-ret:ret;
        int result;
        if(ret>Integer.MAX_VALUE||ret<Integer.MIN_VALUE)
            return 0;
        else result=(int)ret;
        return result;
    }
}
