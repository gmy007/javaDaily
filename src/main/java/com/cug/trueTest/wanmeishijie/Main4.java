package com.cug.trueTest.wanmeishijie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main4 {
    /**
     * 某市要修建公路，目标是使市内任何两个村庄都可以实现公路互通（但不一定有直接公路相连，间接公路可达即可），
     * @param args
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int v=n*(n-1)/2;
        int[][] graph=new int[v][4];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < 4; j++) {
                graph[i][j]=sc.nextInt();
            }
        }
        Arrays.sort(graph,(o1,o2)->o1[2]-o2[2]);
        ArrayList<Integer> sup = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            sup.add(i);
        }
        int ret=0;
        int i=0;

        while(!sup.isEmpty()&&i<v){
            if(graph[i][3]==0){
                ret+=graph[i][2];
            }
            sup.remove((Integer)graph[i][0]);
            sup.remove((Integer)graph[i][1]);
            i++;
        }
        System.out.println(ret);
    }
}
