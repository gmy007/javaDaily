package com.cug.leetcode;

import java.util.*;
public class Demo47 {
    static List<List<Integer>> ret;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ret= new ArrayList<>();
        Arrays.sort(nums);//利用排序保证重复的数字连续出现在相邻位置
        dfs(nums,new ArrayList<Integer>(),0,new boolean[nums.length]);
        return ret;
    }
    public void dfs(int[] nums, List<Integer> cur,int idx,boolean[] vis){
        if(idx == nums.length){
            ret.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(vis[i] ||(i>0 && nums[i] == nums[i-1] && !vis[i-1]) )
                continue;
            cur.add(nums[i]);
            vis[i]=true;
            dfs(nums,cur,idx+1,vis);
            cur.remove(idx);
            vis[i]=false;
        }

    }
}
