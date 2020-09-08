package com.cug.trueTest.kuaishou.test;

import java.util.*;

public class demo7 {
    static Map<String,String> maps=new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        maps.put("2","abc");
        maps.put("3","def");
        maps.put("4","ghi");
        maps.put("5","jkl");
        maps.put("6","mno");
        maps.put("7","pqrs");
        maps.put("8","tuv");
        maps.put("9","wxyz");
        String num=sc.next();
        ArrayList<String> ret = new ArrayList<>();
        part(num,0,"",ret);
        System.out.println(ret);
    }
    public static ArrayList<String> part(String num,int index,String cur,ArrayList<String> ret){
        if(index==num.length()){
            ret.add(cur);
            return ret;
        }
        String n=String.valueOf(num.charAt(index));
        String s = maps.get(n);
        for (int i = 0; i < s.length(); i++) {
            part(num,index+1,s.charAt(i)+cur,ret);
            
        }
        return ret;

    }
}
