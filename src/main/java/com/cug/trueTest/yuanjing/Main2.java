package com.cug.trueTest.yuanjing;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[][] ints=new int[n][2];
        for (int i = 0; i < n; i++) {
            ints[i][0]=sc.nextInt();
            ints[i][1]=sc.nextInt();
        }
        Arrays.sort(ints,(o1,o2)->o1[1]==o2[1]?o1[0]-o2[0]:o1[1]-o2[1]);
        for (int i = 0; i < n; i++) {
            System.out.println(ints[i][0]+" "+ints[i][1]);
        }
    }
}
