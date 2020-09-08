package com.cug.qiuzhao.xiaomi;

import java.util.Scanner;

public class Main2
{   static boolean flag =false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[][] target = {{'A','B','C','E'}, { 'S','F','C','S'},{'A','D','E','E'}};
        flag=false;
        for (int i = 0; i < target.length; i++) {
            if(flag)
                break;
            for (int j = 0; j < target[0].length; j++) {
                if(search(target,i,j,0,s)){
                    System.out.println(true);
                    break;
                }
            }
        }
        if(!flag)
            System.out.println(false);
    }

    public static boolean search(char[][] target ,int i,int j,int cur,String s){
        if(cur >= s.length()){
            flag=true;
            return true;
        }
        if(flag)
            return true;
        if(i<0 || j<0 || i>=target.length || j>=target[0].length || target[i][j]!=s.charAt(cur))
            return false;
        target[i][j]+=256;
        boolean ret =  search(target,i,j+1,cur+1,s) ||search(target,i,j-1,cur+1,s) ||
                search(target,i+1,j,cur+1,s) || search(target,i-1,j,cur+1,s);
        target[i][j]-=256;
        return ret;
    }
}
