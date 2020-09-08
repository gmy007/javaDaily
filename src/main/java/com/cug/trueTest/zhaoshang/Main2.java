package com.cug.trueTest.zhaoshang;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String[] s=new String[n];
        int[] sum=new int[n];
        for (int i = 0; i < n; i++) {
            s[i]=sc.next();
            sum[i]=sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if(s[i].length()==1){
                if(Integer.parseInt(s[i])==sum[i])
                    System.out.println(1);
                else System.out.println(0);
                continue;
            }
            System.out.println(dfs(s[i],sum[i],1,new int[s[i].length()]));
        }
    }
    public static int dfs(String s,int k,int now,int[] sup){
        if(now==s.length()){
            int preIndex=0,pre=0;
            int sum=0;
            for (int i = 1; i < sup.length; i++) {
                if(sup[i]==1||sup[i]==2){
                    if(preIndex==0){
                        sum=Integer.parseInt(s.substring(pre,i));
                    }else {
                        int cur=Integer.parseInt(s.substring(preIndex,i));
                        if (pre == 1)
                            sum += cur;
                        else sum -= cur;
                    }
                    pre=sup[i];
                    preIndex=i;
                }
            }
            if (pre == 1)
                sum += Integer.parseInt(s.substring(preIndex,s.length()));
            else sum -= Integer.parseInt(s.substring(preIndex,s.length()));
            if(sum==k)
                return 1;
            else return 0;
        }
        int val=0;
        sup[now]=0;
        val+=dfs(s,k,now+1,sup);
        sup[now]=1;
        val+=dfs(s,k,now+1,sup);
        sup[now]=2;
        val+=dfs(s,k,now+1,sup);

        return val;
    }
}
