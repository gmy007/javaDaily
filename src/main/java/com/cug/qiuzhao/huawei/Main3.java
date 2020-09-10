package com.cug.qiuzhao.huawei;

import java.util.HashMap;
import java.util.Scanner;

public class Main3 {
    static HashMap<Integer, Integer> maps = new HashMap<>();
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] tree = new int[N][4];
        for (int i = 0; i < N; i++) {
            tree[i][0] = sc.nextInt();
            maps.put(tree[i][0],i);
            tree[i][1] = sc.nextInt();
            tree[i][2] = sc.nextInt();
            tree[i][3] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            dfs(tree,tree[i][0],0);
        }
        System.out.println(max);
    }

    public static void dfs(int[][] tree, int idx,int pre){
        Integer numsIdx = maps.get(idx);
        int cur = tree[numsIdx][1] ^ pre;
        if(cur > max)
            max = cur;
        if(tree[numsIdx][2] != -1){
            dfs(tree,tree[numsIdx][2],cur);
        }
        if(tree[numsIdx][3] != -1){
            dfs(tree,tree[numsIdx][3],cur);}

    }
}
