package com.cug.qiuzhao.didi;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            if( n == 0 || m ==0 ){
                System.out.println("No");
                continue;}
            if(n == 1){
                System.out.println("Yes");
                continue;
            }
            int[][] bridge = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                Arrays.fill(bridge[i], -1);
            }
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int waste = sc.nextInt();
                bridge[x][y] = waste;
                bridge[y][x] = waste;
            }
            boolean[] flags = new boolean[n + 1];
            dfs(bridge, flags, 1, k);
            boolean ret = true;
            for (int i = 1; i < flags.length; i++) {
                ret = ret && flags[i];
                if (!flags[i])
                    break;
            }
            System.out.println(ret ? "Yes" : "No");
        }
    }

    static void dfs(int[][] bridge, boolean[] flag, int idx, int k) {
        flag[idx] = true;
        for (int i = 1; i < bridge[0].length; i++) {
            if (i == idx || bridge[idx][i] == -1 || flag[i])
                continue;
            if (bridge[idx][i] <= k) {
                dfs(bridge, flag, i, k);
            }
        }
    }
}
