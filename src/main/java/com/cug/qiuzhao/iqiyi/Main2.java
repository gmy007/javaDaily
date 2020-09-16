package com.cug.qiuzhao.iqiyi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lists = new ArrayList<>();
        HashMap<Integer, Integer> maps = new HashMap<>();
        int count = 0;
        while(sc.hasNextInt()){
            int nextInt = sc.nextInt();
            maps.put(nextInt,maps.getOrDefault(nextInt,0)+1);
            count++;
        }
        Set<Integer> keySet = maps.keySet();
        for (Integer num : keySet) {
            if(maps.get(num)>count/2)
                System.out.println(num);
        }
    }
}
