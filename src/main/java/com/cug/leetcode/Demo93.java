package com.cug.leetcode;

import java.util.*;
public class Demo93 {
    List<String> ret ;
    int[] segments = new int[4];
    public List<String> restoreIpAddresses(String s) {
        ret = new ArrayList<>();
        if(s.length()>12 || s.length() <3)
            return ret;
        dfs(s,0,0);
        return ret;
    }
    public void dfs(String s, int str,int segment){
        if(segment == 4){
            if(str == s.length()){
                StringBuilder sb= new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    sb.append(segments[i]);
                    if( i == 3)
                        continue;
                    sb.append(".");
                }
                ret.add(sb.toString());
            }
            return;
        }
        if(str == s.length())
            return;
        if(s.charAt(str ) =='0'){
            segments[segment] = 0;
            dfs(s,str+1,segment+1);
        }
        int addr = 0;
        for (int i = str; i <s.length() ; i++) {
            addr = addr*10 + s.charAt(i)-'0';
            if(addr>0 && addr <=0xFF){
                segments[segment] = addr;
                dfs(s,i+1,segment+1);
            }else
                break;
        }

    }
}
