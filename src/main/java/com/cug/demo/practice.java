package com.cug.demo;

import java.util.*;

public class practice {
    public static void main(String[] args) {
        String[] split = "1".split(".");
        System.out.println(split.length);

    }

    public static long gcd(long a,long b){
        if(b>a){
            long temp=a;
            a=b;
            b=temp;
        }
        long val=a%b;
        if(val==0)
            return b;
        else return gcd(b,val);
    }
    public static int fun2(){
        try{ return 0; }
        catch(Exception e){e.printStackTrace();}
        finally{return 1;}
    }
    private static void tokenString() {
        String[][] s = {{"helloworld", "hello world"}, {"this is", "a java program"}};

        System.out.println((new StringTokenizer(s[1][1])).countTokens());
    }

    private static int x = 10;
    private static Integer y = 10;

    public static void updateX(int value) {
        value = 3 * value;
    }

    public static void updateY(Integer value) {
        value = 3 * value;
    }


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        stack.isEmpty();
        for (char c : chars) {
            if (c == '[' || c == '{' || c == '(')
                stack.push(c);
            else if (c == ']' && stack.peek() == '[')
                stack.pop();
            else if (c == '}' && stack.peek() == '{')
                stack.pop();
            else if (c == ')' && stack.peek() == '(')
                stack.pop();

        }
        return stack.size() == 0 ? true : false;
    }

    private static void scannerTest() {
        Scanner scanner = new Scanner(System.in);


        int i = scanner.nextInt();
        int[] a = new int[i];
        for (int j = 0; j < i; j++) {
            a[j] = scanner.nextInt();
        }
        int j = scanner.nextInt();
        int[] b = new int[j];
        for (int k = 0; k < j; k++) {
            b[k] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
