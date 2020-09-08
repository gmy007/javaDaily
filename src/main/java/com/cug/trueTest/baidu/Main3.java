package com.cug.trueTest.baidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] quan=new int[n+1];
        for (int i = 1; i <= n; i++) {
            quan[i]=sc.nextInt();
        }
        int[][] bian=new int[n-1][2];
        for (int i = 0; i < n - 1; i++) {
            int a=sc.nextInt(),b=sc.nextInt();
            if(quan[a]>quan[b]){
                bian[i][0]=b;
                bian[i][1]=a;
            }else {
                bian[i][0]=a;
                bian[i][1]=b;
            }
        }
        Arrays.sort(bian,(a,b)->a[0]==b[0]?quan[a[1]]-quan[b[1]]:quan[a[0]]-quan[b[0]]);
        int ret=2+dfs(quan,bian,bian[0][0],bian[0][1]);
        for (int i = 1; i < n-1; i++) {
            if(bian[i][0]==bian[i-1][0])
                continue;
            ret=Math.max(dfs(quan,bian,bian[i][0],bian[i][1]),ret);
        }
        System.out.println(ret);
    }

    private static int dfs(int[] quan, int[][] bian, int u, int v) {
        for (int i = 0; i < bian[0].length-1; i++) {
            if(bian[i][0]==v)
                return 1+dfs(quan,bian,v,bian[i][1]);
        }

        return 0;
    }
}
