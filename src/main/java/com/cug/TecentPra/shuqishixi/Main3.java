package com.cug.TecentPra.shuqishixi;

import java.util.*;
public class Main3{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int N=sc.nextInt();
            int[] nums=new int[N];
            for(int i=0;i<N;i++){
                nums[i]=sc.nextInt();
            }
            Arrays.sort(nums);
            if(nums[0] == nums[N-1]){
                int tmp = (N*(N-1))/2;
                System.out.println(tmp + " " + tmp);
                continue;
            }
            Map<Integer,Integer> maps=new TreeMap<>();
            for(int i=0;i<N;i++){
                if(maps.containsKey(nums[i]))
                    maps.put(nums[i],maps.get(nums[i])+1);
                else
                    maps.put(nums[i],1);
            }
            int countMin=0;
            if(maps.size()==N){
                int min=Math.abs(nums[1]-nums[0]);
                for(int i=1;i<N;i++){
                    int cha=Math.abs(nums[i]-nums[i-1]);
                    if(cha<min){
                        min=cha;
                        countMin=1;
                    }else if(cha==min){
                        countMin++;
                    }
                }
            }else {
                for(Integer key:maps.keySet()){
                    int val=maps.get(key);
                    if(val>1){
                        countMin+=(val*(val-1))/2;
                    }
                }
            }
            int countMax=maps.get(nums[0])*maps.get(nums[N-1]);
            System.out.println(countMin+" "+countMax);
        }
    }

}