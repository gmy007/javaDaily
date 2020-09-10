package com.cug.leetcode.mianshijindian;


import java.util.*;

public class Demo0501 {
    public int insertBits(int N, int M, int i, int j) {
        int temp = 1<<(j-i+1);
        temp=temp-1;
        temp=temp<<i;
        temp=~temp;
        N=N&temp;
        return N|M;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        
        return output;
    }


}
