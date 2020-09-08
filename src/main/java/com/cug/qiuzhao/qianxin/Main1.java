package com.cug.qiuzhao.qianxin;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    public static void main(String[] args) {
//        fun1();
        System.out.println(reletive_7(new int[]{1, 1, 2}));
    }

    private static void fun1() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int C = sc.nextInt();
            int n = sc.nextInt();
            int[] w = new int[n];
            int[] v = new int[n];

            for (int i = 0; i < n; i++) {
                w[i] = sc.nextInt();
                v[i] = sc.nextInt();
            }
            System.out.println(dpBestValue(w, v, C));
        }
    }

    private static int dpBestValue(int[] w, int[] v, int C) {
        int n = w.length;
        if (n == 0)
            return 0;
        int[] memo = new int[C + 1];

        for (int i = 0; i < n; i++) {
            for (int j = w[i]; j <= C; j++) {

                memo[j] = Math.max(memo[j], memo[j - w[i]] + v[i]);

            }
        }
        return memo[C];
    }

    public static int reletive_7(int[] digit) {
        zuzhuang(digit, new boolean[digit.length], 0, 0);
        return ret;
    }

    static int ret = 0;

    public static void zuzhuang(int[] nums, boolean[] b, int now, int idx) {
        if (idx == nums.length && now % 7 == 0)
            ret++;
        for (int i = 0; i < nums.length; i++) {
            if (!b[i]) {
                b[i] = true;
                zuzhuang(nums, b, now * 10 + nums[i], idx + 1);
                b[i] = false;
            }

        }


    }
}
