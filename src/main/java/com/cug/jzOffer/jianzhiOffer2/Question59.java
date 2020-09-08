package com.cug.jzOffer.jianzhiOffer2;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Question59 {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        ArrayList<Integer> ret = new ArrayList<>();
        if(size>num.length || num==null||size<1)
            return ret;
        for (int i = 0; i <size ; i++) {
            priorityQueue.add(num[i]);
        }
        ret.add(priorityQueue.peek());
        for (int i =size,j=0; i < num.length; i++,j++) {
            priorityQueue.remove(num[j]);
            priorityQueue.add(num[i]);
            ret.add(priorityQueue.peek());

        }
        return ret;
    }
}
