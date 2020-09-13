package com.cug.qiuzhao.netease;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        maps = new HashMap<>();
        System.out.println(longestString(s));
    }
    static HashMap<Character,Integer> maps ;
    public static int longestString(String s){
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            if(chars[i] == 'a' || chars[i] == 'b' ||chars[i] == 'c'
            ||chars[i] == 'x' ||chars[i] == 'y' ||chars[i] == 'z')
            maps.put(chars[i],maps.getOrDefault(chars[i],0)+1);
        }
        HashMap<Character, Integer> temp = new HashMap<>(maps);
        if(checkString(maps))
            return s.length();
        int max = 0;
        for (int i = n-1; i >=0; i--) {
            if(chars[i] == 'a' || chars[i] == 'b' ||chars[i] == 'c'
                    ||chars[i] == 'x' ||chars[i] == 'y' ||chars[i] == 'z'){
                maps.put(chars[i],maps.get(chars[i])-1);
                if(checkString(maps)){
                    max = i;
                    break;
                }
            }
        }
        for (int i = 0; i <n; i++) {
            if(chars[i] == 'a' || chars[i] == 'b' ||chars[i] == 'c'
                    ||chars[i] == 'x' ||chars[i] == 'y' ||chars[i] == 'z'){
                temp.put(chars[i],temp.get(chars[i])-1);
                if(checkString(temp)){
                    max = Math.max(max,n-1-i);
                    break;
                }
            }
        }
        return max;
    }
    static boolean checkString(HashMap<Character, Integer> tempMaps){
        Set<Character> characters = tempMaps.keySet();
        boolean flag = true;
        for (Character c : characters) {
            if(tempMaps.get(c) % 2 !=0){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
