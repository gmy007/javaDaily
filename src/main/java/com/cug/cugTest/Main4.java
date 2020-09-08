package com.cug.cugTest;

import java.util.Scanner;
public class Main4{
    static int ret=0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] nums=new int[N];
        for(int i=0;i<N;i++){
            nums[i]=sc.nextInt();
        }
        ret=nums[0];
        for (int i = 1; i <N ; i++) {
            ifSame(ret,nums[2]);
        }

    }
    public static boolean ifSame(int same ,int b){
        if(same==b){
            ret=same;
            return true;
        }
        if(same>1000000000||b>1000000000)
            return false;

        return ifSame(same,b*2)||ifSame(same*2,b)||ifSame(same*2,b*2);
    }

}
