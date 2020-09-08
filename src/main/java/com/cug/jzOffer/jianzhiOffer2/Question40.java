package com.cug.jzOffer.jianzhiOffer2;

import java.util.ArrayList;

public class Question40 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(k>input.length||k<=0)
            return list;
        findKthSmall(input,k);
        for (int i = 0; i <k ; i++) {
            list.add(input[i]);

        }
        return list;

    }
    public void findKthSmall(int[] input ,int k){
        int l=0,h=input.length-1;
        while(l<h){
            int j=partition(input,l,h);
            if(j==k)
                return;
            if(j>k)
                h=j-1;
            else
                l=j+1;
        }
    }
    public int partition(int[] nums,int l,int h){
        int p=nums[l];
        int i=l,j=h+1;
        while(true){
            while(i!=h && nums[++i]<p);
            while(j!=l && nums[--j]>p);
            if(i>=j)
                break;
            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }

    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
