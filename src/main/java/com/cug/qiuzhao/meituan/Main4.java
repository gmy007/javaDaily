package com.cug.qiuzhao.meituan;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer>[] adj = new TreeSet[n]; ;
        for(int i = 0; i < n; i ++)
            adj[i] = new TreeSet<Integer>();
        int k = sc.nextInt();
        for(int i = 0; i < n; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(adj[a].contains(b)) continue;
            adj[a].add(b);
            adj[b].add(a);
        }

    }
    public static int getPath(TreeSet<Integer>[] adj,int n,int k,int[] level){
        int min =-1;
        int max =0;
        long ret = n;
        boolean[] bool = new boolean[n];
        for (int i = 0; i < n; i++) {
            bool[i]=true;
            max = level[i];
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(i);
            while(!queue.isEmpty()){
                Integer poll = queue.poll();
                Iterator<Integer> iterator = adj[poll].iterator();
                while(iterator.hasNext()){
                    Integer next = iterator.next();
                    int curLevel = level[next];
                    if(min == -1)
                        min=curLevel;
                    if(Math.abs(max-curLevel)<=k && Math.abs(min-curLevel)<=k){
                        ret++;
                        queue.add(next);
                    }
                }


            }
        }
        return 0;

    }

}
