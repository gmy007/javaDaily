package com.cug.TecentPra;
import java.util.Scanner;
import java.util.Stack;
public class Main2{
    public static void  main(String[] args){
        Scanner sc=new Scanner(System.in);
        int length=sc.nextInt();
        int[] nums=new int[length];
        for(int i=0;i<length;i++){
            nums[i]=sc.nextInt();
        }
        Stack<Integer> s=new Stack<>();
        int[] ret=new int[length];
        for(int i=length-1;i>=0;i--){
            ret[i]=s.size();
            while(!s.isEmpty() && (nums[i]>=s.peek())){
                s.pop();
            }
            s.push(nums[i]);
        }
        s.clear();
        for(int i=0;i<length;i++){
            ret[i]=ret[i]+1+s.size();
            System.out.printf(ret[i]+" ");
            while(!s.isEmpty() && (nums[i]>=s.peek())){
                s.pop();
            }
            s.push(nums[i]);
        }

    }
}
