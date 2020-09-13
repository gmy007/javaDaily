package com.cug.qiuzhao.netease;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int[][] tree = new int[m+1][2];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            if(!list.contains(id))
                list.add(id);
            max= Math.max(max,id);
            sc.next();
            if(tree[id][0] == 0)
                tree[id][0] = sc.nextInt();
            else
                tree[id][1] = sc.nextInt();
        }
        int ret = 0;
        for (int i = 1; i <= max; i++) {
            if(tree[i][0] !=0 && tree[i][1]!=0 && !list.contains(tree[i][0]) && !list.contains(tree[i][1]))
                ret ++;
        }
        System.out.println(ret);

    }
}
