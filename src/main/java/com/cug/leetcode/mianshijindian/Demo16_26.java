package com.cug.leetcode.mianshijindian;

import java.util.Stack;

public class Demo16_26 {
//加减乘除计算
    public int calculate(String s) {
        s=s.replace(" ","");
        Stack<Integer> stack = new Stack<>();
        char oper='+';
        int num=0;
        for (int i = 0; i < s.length(); i++) {
            char cur=s.charAt(i);
            if(!isOper(cur))
                num=num*10+(cur-'0');
            if(isOper(cur)|| i==s.length()-1) {
                int pre;
                switch (oper){
                    case '+' :
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                         pre=stack.pop();
                        stack.push(pre*num);
                        break;
                    case '/':
                        pre=stack.pop();
                        stack.push(pre/num);
                        break;

                }
                num=0;
                oper=cur;

            }
        }
        int ret=0;
        while(!stack.isEmpty()){
            ret=ret+stack.pop();
        }
        return ret;
    }
    public static boolean isOper(char c){
        if(c=='+' || c=='-' || c=='/' || c=='*')
            return true;
        else return false;
    }
}
