package com.cug.leetcode;

public class Demo9 {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        String s = String.valueOf(x);
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        String s1 = s.substring(0, n / 2);
        if(n % 2==0){
            sb.append(s.substring(n /2, n));
        }else {
            sb.append(s.substring(n /2+1, n));
        }
        return sb.reverse().toString().equals(s1);

    }
}
