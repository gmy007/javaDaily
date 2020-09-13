package com.cug.qiuzhao.xiaohongshu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[][] box = new int[n][3];
            for (int i = 0; i < n; i++) {
                box[i][0] = sc.nextInt();
                box[i][1] = sc.nextInt();
                box[i][2] = sc.nextInt();
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, doBox(box, box[i][0], box[i][1]) + box[i][2]);
                max = Math.max(max, doBox(box, box[i][1], box[i][2]) + box[i][0]);
                max = Math.max(max, doBox(box, box[i][0], box[i][2]) + box[i][1]);
            }
            System.out.println(max);
        }
    }

    static int doBox(int[][] box, int x, int y) {
        int ret = 0;
        for (int i = 0; i < box.length; i++) {

            int height1 = 0;
            int height2 = 0;
            int height3 = 0;
            if (box[i][0] < x && box[i][1] < y || (box[i][0] < y && box[i][1] < x))
                height1 = box[i][2] + doBox(box, box[i][0], box[i][1]);
            if (box[i][0] < x && box[i][2] < y || (box[i][0] < y && box[i][2] < x))
                height2 = box[i][1] + doBox(box, box[i][0], box[i][2]);
            if (box[i][1] < x && box[i][2] < y || (box[i][1] < y && box[i][2] < x))
                height3 = box[i][0] + doBox(box, box[i][2], box[i][1]);
            int max = Math.max(height1, Math.max(height2, height3));
            ret = Math.max(ret, max);
        }
        return ret;
    }

    static int findMin(int[] tree) {
        ArrayList<Integer> lists = new ArrayList<>();
        int ret = 1;
        for (int i = 0; i < tree.length; i++) {
            lists.add(tree[i]);
            if (tree[i] == ret) {
                while (lists.contains(ret))
                    ret++;
            }
        }
        return ret;
    }

    static int solution(String s) {
        int n = s.length();
        int i = 0, count = 1;
        int j = s.lastIndexOf(s.substring(i, i + 1));
        while (j != n - 1) {
            i = j + 1;
            j = s.lastIndexOf(s.substring(i, i + 1));
            count++;
        }
        return count;
    }

    static int doCut(String s, int idx) {
        int n = s.length();
        if (idx == n - 1)
            return 1;
        int j = s.lastIndexOf(s.substring(idx, idx + 1));
        int min = Integer.MAX_VALUE;
        while (j != -1 && j >= idx) {
            min = Math.min(1 + doCut(s, j + 1), min);
            j = s.lastIndexOf(s.substring(idx, idx + 1), j - 1);
        }
        return min;
    }
}
