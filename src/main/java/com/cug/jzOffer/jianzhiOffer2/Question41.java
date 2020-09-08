package com.cug.jzOffer.jianzhiOffer2;

import java.util.PriorityQueue;

public class Question41 {
    int count=0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
    public void Insert(Integer num) {

        if(count%2==0){
            maxHeap.add(num);
            int max=maxHeap.poll();
            minHeap.add(max);
        }else {
            minHeap.add(num);
            int min =minHeap.poll();
            maxHeap.add(min);
        }
        count++;
    }

    public Double GetMedian() {
        if(count %2==0){
            return new Double (maxHeap.peek()+minHeap.peek())/2;
        }else
            return new Double(minHeap.peek());
    }
}
