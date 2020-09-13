package com.cug.qiuzhao.netease;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        s = sc.nextLine();
        String[] s2 = s.split(" ");
        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0]= sc.nextInt();
            nums[i][1]= sc.nextInt();
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> man = new ArrayList<>();
            ArrayList<Integer> women = new ArrayList<>();
            man.add(nums[i][0]);
            women.add(nums[i][1]);
            int count = 1;
            for (int j = 0; j < n; j++) {
                if(!man.contains(nums[j][0]) && !women.contains(nums[j][1])){
                    count++;
                    man.add(nums[j][0]);
                    women.add(nums[j][1]);
                }
            }
            max = Math.max(count,max);
        }
        System.out.println(max);

    }

}
