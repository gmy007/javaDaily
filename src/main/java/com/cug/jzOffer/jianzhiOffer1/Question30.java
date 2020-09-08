package com.cug.jzOffer.jianzhiOffer1;

import java.util.Arrays;
import java.util.Stack;

public class Question30 {

    int size = 0;
    int min = Integer.MAX_VALUE;
    Stack<Integer> minStack = new Stack<>();
    Integer[] elements = new Integer[10];

    public void push(int node) {
        size++;
        ensureSize();
        elements[size - 1] = node;
        if (node < min) {
            min = node;
            minStack.push(node);
        } else
            minStack.push(min);


    }

    public void ensureSize() {
        int len = elements.length;
        if (size > len) {
            int newLen = len * 2;
            Arrays.copyOf(elements, newLen);
        }
    }


    public void pop() {
        if (size == 0)
            return;
        elements[size - 1] = null;
        size--;
        minStack.pop();
        min = minStack.peek();
    }

    public int top() {
        if (size == 0)
            return (Integer) null;
        return elements[size - 1];
    }

    public int min() {
        return minStack.peek();

    }
}
