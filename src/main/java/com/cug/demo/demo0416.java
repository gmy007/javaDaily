package com.cug.demo;

import java.util.Scanner;

public class demo0416
{
    static String[] s={"+","-","*","/"};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            double a = in.nextDouble(), b = in.nextDouble(), c = in.nextDouble(), d = in.nextDouble();
            double[] nums = new double[]{a, b, c, d};

            System.out.println(game(1,nums,0,new boolean[4]));
        }

    }
    static double[] p=new double[4];
    static String[] q=new String[3];
    public static boolean fun(int now,double[] nums,boolean[] visited){
        if(now>=4){
            for (int i = 0; i < 4; i++) {
                if(!visited[i])
                    p[now]=nums[i];
            }
            for (int i = 0; i < 3; i++) {
                if(q[i].equals("*") ){
                    p[i]=p[i]*p[i+1];
                    p[i+1]=0;
                }
                if(q[i].equals("/") ){
                    p[i]=p[i]/p[i+1];
                    p[i+1]=0;
                }
            }
            int ret=0;
            for (int i = 0; i < 4; i++) {
                ret+=p[i];
            }
            if(ret==24)
                return true;
            else return false;
        }
        boolean b=false;
        for (int i = 0; i < 4; i++) {
            if(!visited[i]){
                visited[i]=true;
                p[now]=nums[i];
                for (int j = 0; j < 4; j++) {
                    q[now]=s[j];
                    b=b||fun(now+1,nums,visited);
                    if(b)
                        return b;
                }
                visited[i]=false;
            }

        }
        return b;
    }
    public static  boolean game(int now,double[] nums,double ret,boolean[] visited){

        if(now>4){
            if(ret==24)
                return true;
            else return false;
        }
        boolean b=false;
        if(now==1){
            for (int i = 0; i < 4; i++) {
                ret=nums[i];
                visited[i]=true;
                b=b||game(now+1,nums,ret,visited);
                visited[i]=false;
                if(b)
                    return true;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(!visited[i]){
                visited[i]=true;
                b=b||game(now+1,nums,ret*nums[i],visited)||game(now+1,nums,ret+nums[i],visited)
                        || game(now+1,nums,ret-nums[i],visited)||game(now+1,nums,ret/nums[i],visited);
                visited[i]=false;
            }
            if(b)
                return true;

        }
        return b;

    }
}
