package com.cug.qiuzhao.tencent;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Main3 {
    static class CompareString {
        String s;
        int sum ;
        public CompareString(String s,int sum){
            this.s =s ;
            this.sum = sum;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        PriorityQueue<CompareString> minHeap = new PriorityQueue<>((o1,o2)->{
            if(o1.sum != o2.sum)
                return o1.sum-o2.sum;
            return o1.s.compareTo(o2.s);
        });
        PriorityQueue<CompareString> maxHeap = new PriorityQueue<>((o1,o2)->{
            if(o1.sum != o2.sum)
                return o2.sum-o1.sum;
            return o1.s.compareTo(o2.s);
        });
        HashMap<String, Integer> maps = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String cur = sc.next();
            maps.put(cur,maps.getOrDefault(cur,0)+1);
        }
        Set<String> strings = maps.keySet();
        for (String string : strings) {
            minHeap.add(new CompareString(string,maps.get(string)));
            maxHeap.add(new CompareString(string,maps.get(string)));
        }
        for (int i = 0; i < K; i++) {
            CompareString cur = maxHeap.poll();
            System.out.println(cur.s+" "+cur.sum);
        }
        for (int i = 0; i < K; i++) {
            CompareString cur = minHeap.poll();
            System.out.println(cur.s+" "+cur.sum);
        }
    }

}
