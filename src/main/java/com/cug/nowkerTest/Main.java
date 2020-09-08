package com.cug.nowkerTest;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        int pre=nums[0];
        int count=1;
        for(int i=1;i<n;){
            if(i<n && nums[i]>=pre){
                while(i<n&&nums[i]>=pre){
                    pre=nums[i];
                    i++;
                }
                if(i<n){
                    pre=nums[i];
                    i++;
                    count++;
                } else break;
            }
            if(i<n && nums[i]<=pre){
                while(i<n&&nums[i]<=pre){
                    pre=nums[i];
                    i++;
                }
                if(i<n){
                    pre=nums[i];
                    i++;
                    count++;
                } else break;

            }
        }
        System.out.println(count);
    }
}