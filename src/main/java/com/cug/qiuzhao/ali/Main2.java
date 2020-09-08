package com.cug.qiuzhao.ali;

import com.cug.IO.Main;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        String[] s=new String[n];
        for (int i = 0; i < n; i++) {
            s[i]=sc.nextLine();
        }
        int[][] tar = new int[q][4];
        for (int i = 0; i < q; i++) {
            tar[i][0]=sc.nextInt();
            tar[i][1]=sc.nextInt();
            tar[i][2]=sc.nextInt();
            tar[i][3]=sc.nextInt();
        }
        for (int i = 0; i < q; i++) {

        }
    }
    static int[][] move={{0,1},{1,0},{-1,0},{0,-1}};
    public static int fastMove(String[]s,int sx,int sy,int bx,int by){
        if(sx==bx && sy==by)
            return 0;
        int ret =0;
        for (int i = 0; i < 4; i++) {
            if(check(s,sx+move[i][0],sx+move[i][1]))
                ret = Math.min(ret,fastMove(s,sx+move[i][0],sx+move[i][1],bx,by));
        }
        return ret;
    }
    public static boolean check(String[] s ,int x , int y){
        return x>=0&&y>=0&&x<s.length&& y<s[0].length();
    }

}
