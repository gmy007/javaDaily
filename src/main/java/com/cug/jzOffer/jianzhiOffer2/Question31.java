package com.cug.jzOffer.jianzhiOffer2;

import java.util.Stack;

public class Question31 {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        int[] b={4,5,3,2,1};
        System.out.println(a.length);
        new Question31().IsPopOrder(a,b);
    }
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0 ||popA.length==0)
            return false;
        Stack<Integer> stack = new Stack<>();
        int j=0;
        for (int i = 0; i <pushA.length ; i++) {
            if(stack.isEmpty()|| stack.peek()!=popA[j])
                stack.push(pushA[i]);
            else {
                stack.pop();
                i--;
                j++;
            }

        }
        while(j<popA.length){
            if(stack.pop()!=popA[j])
                return false;
            j++;
        }
        return true;
    }
}
