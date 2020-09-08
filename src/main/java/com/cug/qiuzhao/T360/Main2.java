package com.cug.qiuzhao.T360;

import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {
    static class Num {
        int val;

        Num(int v) {
            this.val = v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] move = new int[m];
        for (int i = 0; i < m; i++) {
            move[i] = sc.nextInt();
        }
        int[] nums = modify(move, n);
        for (int i = str; i < n; i++) {
            System.out.print(nums[i]+1+" ");
        }
        for (int i = 0; i < str; i++) {
            System.out.print(nums[i]+1+" ");
        }

    }
    static int str;
    static int end;
    public static int[] modify(int[] move, int n) {
        int[] nums = new int[n];
        str = 0;end = n-1;
        int adjust = 0;
        for (int i = 0; i < n; i++) {
            nums[i]=i;
        }
        for (int i = 0; i < move.length; i++) {
            if (move[i] == 1) {
                if (adjust % 2 == 1) {
                    for (int j = str; j < n; j++) {
                        if(j==n-1){
                            int temp = nums[j];
                            nums[j]=nums[0];
                            nums[0]=temp;
                            for (int k = 1; k < str; k++) {
                                if(k==str-1)
                                    continue;
                                temp = nums[k];
                                nums[k]=nums[k+1];
                                nums[k+1]=temp;
                                k++;
                            }
                            continue;
                        }
                        int temp = nums[j];
                        nums[j]=nums[j+1];
                        nums[j+1]=temp;
                        j++;
                    }
                    adjust=0;
                }
                str = (str+1)%n;
                end = (end+1)%n;
            } else {
                adjust++;

            }
        }
        return nums;
    }


}
