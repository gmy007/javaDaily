package com.cug.qiuzhao.duxiaoman;

import java.util.HashMap;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String color = sc.next();
        String s = sc.next();
        HashMap<Character, Integer> maps = new HashMap<>();
        char[] chars = color.toCharArray();
        for (int i = 0; i < color.length(); i++) {
            char c = chars[i];
            maps.put(c,maps.getOrDefault(c,0)+1);
        }
        char[] kuai = s.toCharArray();
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = kuai[i];
            if(maps.containsKey(c) && maps.get(c)>0) {
                maps.put(c, maps.get(c) - 1);
                ret++;
            }
        }
        System.out.println(ret);

    }
}
