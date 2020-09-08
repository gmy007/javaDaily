package com.cug.nowkerTest.wangyi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main3
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] grade=new int[n];
        for (int i = 0; i < n; i++) {
            grade[i]=sc.nextInt();
        }
        int q=sc.nextInt();
        HashMap<Integer, Integer> map = create(grade, n);
        while(q>0){
            q--;
            int stu=sc.nextInt()-1;
            double val = map.get(grade[stu]);
            System.out.println(String.format("%.6f",(val-1)*100/n));
        }
    }
    public static HashMap<Integer,Integer> create(int[] grade ,int n){
        int[] copy= Arrays.copyOf(grade,n);
        Arrays.sort(copy);
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(map.containsKey(copy[i])){
                map.put(copy[i],map.get(copy[i])+1);
                count++;
            }else {
                count++;
                map.put(copy[i],count);
            }

        }
        return map;
    }

}
