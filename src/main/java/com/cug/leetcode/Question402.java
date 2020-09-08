package com.cug.leetcode;

import java.util.LinkedList;


public class Question402 {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] chars = num.toCharArray();

        for (char c : chars) {
            if(stack.size()>0 && k>0 && stack.peekLast()>c){
                stack.removeLast();
                k--;
            }
            stack.addLast(c);
        }
        while(k>0){
            stack.removeLast();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        boolean leadZero=true;
        for (Character c : stack) {
            if(c=='0'&&leadZero)continue;
            leadZero=false;
            sb.append(c);
        }
        if(sb.length()==0)return "0";
        return sb.toString();
    }
}
