package com.cug.qiuzhao.iqiyi;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lists = new ArrayList<>();
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            lists.add(num);
        }
        Integer[] integers = lists.toArray(new Integer[lists.size()]);
        ArrayList<Integer[]> ret = threeSum(integers);
        for (Integer[] ints : ret) {
            for (int i = 0; i < ints.length; i++) {
                System.out.println(ints[i] + " ");
            }
        }
    }

    static ArrayList<Integer[]> threeSum(Integer[] nums) {
        ArrayList<Integer[]> ret = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int end = n - 1;
            int target = -nums[i];
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                while (j < end && nums[j] + nums[end] > target)
                    end--;
                if (j == end)
                    break;
                if (nums[j] + nums[end] == target) {
                    Integer[] ints = new Integer[3];
                    ints[0] = nums[i];
                    ints[1] = nums[j];
                    ints[2] = nums[end];
                    Arrays.sort(ints);
                    ret.add(ints);
                }
            }

        }
        return ret;
    }
}
