package com.cug.leetcode;
import java.util.*;

public class Demo46 {
    public static void main(String[] args) {
        permute(new int[]{1,2,3});
    }
    static List<List<Integer>> ret;
    public static List<List<Integer>> permute(int[] nums) {
        ret = new ArrayList<>();
        doPermute(nums,new ArrayList<Integer>(), nums.length,new boolean[nums.length]);
        return ret;

    }
    static void  doPermute(int[] nums,List<Integer> cur,int idx,boolean[] flag){
        if(idx == 0){
            ret.add(new ArrayList<>(cur));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(flag[i])
                continue;
            cur.add(nums[i]);
            flag[i]=true;
            doPermute(nums,cur,idx-1,flag);
            flag[i]=false;
            cur.remove(cur.size()-1);
        }
    }
}
