package com.cug.jzOffer.jianzhiOffer2;

import java.util.Arrays;

public class Question48 {
    public int longestSubStringWithoutDup(String str){
        int curLen=0;
        int maxLen=0;
        int[] preIndex=new int[26];
        Arrays.fill(preIndex,-1);
        for (int i = 0; i <str.length() ; i++) {
            int c=str.charAt(i)-'a';
            int pre=preIndex[c];
            if(pre==-1 || i-pre>curLen)
                curLen++;
            else {
                maxLen=Math.max(maxLen,curLen);
                curLen=i-pre;
            }
            preIndex[c]=i;
        }
        return Math.max(maxLen,curLen);
    }
}
