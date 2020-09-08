package com.cug.trueTest.Tecent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        while(n-->0){
            int q=sc.nextInt();
            LinkedList<Integer> queue = new LinkedList<>();
            while(q-->0){
                String s = sc.next();
                if(s.contains("PUSH")){
                    String[] sp = s.split(" ");
                    Integer num = sc.nextInt();
                    queue.addLast(num);
                }
                if(s.contains("TOP")){
                    Integer num = queue.peekFirst();
                    if(null==num)
                        System.out.println(-1);
                    else System.out.println(num);
                }
                if(s.contains("POP")){
                    try{
                        queue.removeFirst();
                    }catch (Exception e){
                        System.out.println(-1);
                    }
                }
                if(s.contains("SIZE")){
                    System.out.println(queue.size());
                }
                if(s.contains("CLEAR")){
                    queue.clear();
                }
            }

        }
    }
}
