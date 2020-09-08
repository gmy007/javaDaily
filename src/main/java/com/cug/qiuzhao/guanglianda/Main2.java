package com.cug.qiuzhao.guanglianda;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            long[] nums = new long[4];
            for (int i = 0; i < 4; i++) {
                nums[i] = sc.nextLong();
            }

            System.out.println(getBalance(nums));
        }

    }

    public static long getBalance(long[] nums) {
        Arrays.sort(nums);
        long ret = 0;
        for (int i = 0; i < 4; i++) {
            ret += nums[i];
        }
        ret = ret - (ret % 4);
        return isBalance(nums) ? ret : -1;
    }

    public static boolean isBalance(long[] nums) {
        long ret = 0;
        for (int i = 0; i < 4; i++) {
            ret += nums[i];
        }
        long balanceNum = ret / 4;
        long move = ret % 4;
        for (int i = 3; i >= 0; i--) {
            if (nums[i] > balanceNum && (nums[i] - balanceNum) % 2 != 0)
                return false;
            move-=nums[i] - balanceNum;
        }
        return move==0;

    }

}
