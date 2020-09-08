package com.cug.jzOffer.jianzhiOffer2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Question40_1 {
    static class Node{
        String val;
        int count;
        Node(String val,int count){
            this.count=count;
            this.val=val;
        }
    }
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<Node> heap = new PriorityQueue<>((a,b)->a.count==b.count?a.val.compareTo(b.val):b.count-a.count);
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt(),k=sc.nextInt();

        for (int i = 0; i < N; i++) {
            String cur=sc.next();
            if(map.containsKey(cur))
                map.put(cur,map.get(cur)+1);
            else map.put(cur,1);

        }
        for (Map.Entry<String, Integer> en : map.entrySet()) {
            heap.add(new Node(en.getKey(),en.getValue()));
        }
        for (int i = 0; i < k; i++) {
            Node poll = heap.poll();
            System.out.println(poll.val+" "+poll.count);
        }

    }
}
