package com.cug.trueTest.kuaishou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            ArrayList<Integer> list = new ArrayList<>();
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            for (int i = 0; i < s1.length; i++) {
                list.add(Integer.parseInt(s1[i]));
            }
            for (Integer ret : search(list)) {
                System.out.print(ret+" ");
            }
        }


    }
    
    public static List<Integer> search(ArrayList<Integer> list){
        int len=list.size();
        int[] dp=new int[len];
        dp[0]=-1;
        ArrayList<Integer> sup = new ArrayList<>();
        boolean[] visited=new boolean[len];
        sup.add(list.get(0));
        List<Integer> ret = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            int cur=list.get(i);
            if(sup.contains(cur))
                visited[i]=true;
            int pre=list.get(i-1);
            if(cur>pre) {
                if(dp[i-1]==-1)
                    dp[i]=-1;
                else if(list.get(dp[i-1])>cur){
                    dp[i]=dp[i-1];
                    ret.add(i);
                }
            }else if(cur<pre){
                if(dp[i-1]==-1&&!visited[i-1]){
                    dp[i]=i-1;
                    ret.add(i);
                }else dp[i]=-1;

            }else dp[i]=-1;
            sup.add(cur);

        }

        if(ret.size()==0)
            ret.add(-1);
        return ret;
    }
}
