package com.cug.qiuzhao.netease;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        TreeSet<Integer>[] adj = new TreeSet[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new TreeSet<Integer>();
        }
        for (int i = 0; i < n-1; i++) {
            int b = sc.nextInt();
            int a = i+1;
            adj[a].add(b);
            adj[b].add(a);
        }
        System.out.println(dfs(adj,0,new boolean[n],k));
    }
    static int max = 0;
    public static int dfs(TreeSet<Integer>[] adj,int idx,boolean[] flag,int k){
        if(k == 0)
            return 1;
        Iterator<Integer> iterator = adj[idx].iterator();
        int ret = 1;
        while(iterator.hasNext()){
            Integer next = iterator.next();
            if(flag[next])
                continue;
            else {
                flag[next]=true;
                ret = Math.max(ret,dfs(adj,next,flag,k-1));
                flag[next]=false;
            }

        }
        return ret;
    }
}
