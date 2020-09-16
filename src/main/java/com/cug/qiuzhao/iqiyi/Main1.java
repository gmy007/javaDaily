package com.cug.qiuzhao.iqiyi;


import java.util.HashSet;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(getLongestString(s));
    }
    static int getLongestString(String s){
        char[] chars = s.toCharArray();
        int n = chars.length;
        HashSet<Character> sets = new HashSet<>();
        int idx = -1;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if(i!=0){
                sets.remove(chars[i-1]);
            }
            while(idx + 1 <n && ! sets.contains(chars[idx+1])){
                sets.add(chars[idx+1]);
                idx++;
            }
            ret = Math.max(ret, idx-i +1);
        }
        return ret;
    }
}
