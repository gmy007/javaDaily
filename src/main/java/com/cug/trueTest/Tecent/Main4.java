package com.cug.trueTest.Tecent;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main4 {
    static class MyQueue{
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(node);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }

        }

        public int pop() {

            return stack1.pop();
        }
        public int peek(){
            return stack1.peek();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        LinkedList<Integer> queue = new LinkedList<>();
        while(n-->0){
            String s = sc.next();

            if(s.contains("add")){
                int num = sc.nextInt();
                queue.addLast(num);
            }
            if(s.contains("peek")){
                System.out.println(queue.peekFirst());
            }
            if(s.contains("poll")){
                queue.removeFirst();
            }
        }
    }
}
