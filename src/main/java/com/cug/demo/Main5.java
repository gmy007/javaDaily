package com.cug.demo;

import java.util.Scanner;
import java.util.Stack;

public class Main5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

    }

    public Main5() {
        super();
    }

    public boolean fun(String s){
        int i=0;
        int count=0;
        while(i<s.length()){
            if(s.charAt(i)=='(')
                count++;
            else if(s.charAt(i)==')')
                count--;
            else return false;
            i++;
        }

        return count==0?true:false;
    }
}
