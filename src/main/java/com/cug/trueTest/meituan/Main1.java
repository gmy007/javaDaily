package com.cug.trueTest.meituan;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main1 {
    //!!!!!!!!!!!!!!!!正确!!!!!!!!!!!!!!!!
    //大河弯弯向东流，就是这么牛
    //不过这题应该用栈
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] card = str.split(" ");
        if (card.length == 1) {
            if(card[0].equals("true")||card[0].equals("false")){
                System.out.println(card[0]);
                return;
            }else {System.out.println("error");
                return;
            }

        }
        if(card[0].equals("and")&&card[0].equals("or")){
            System.out.println("error");
            return;
        }
        if(card.length%2==0){
            System.out.println("error");
            return;
        }
        ArrayList<String> card2=new ArrayList<>();

        int i=1;
        for (;i<card.length-1;i++) {
            if ("and".equals(card[i])) {
                if("true".equals(card[i-1])&&"true".equals(card[i+1])){
                    card2.add("true");
                    i=i+1;
                }
                else if("or".equals(card[i-1])||"or".equals(card[i+1])||"and".equals(card[i-1])||"and".equals(card[i+1]))
                {
                    System.out.println("error");
                    return;
                }else {card2.add("false");i=i+2;}
            }else card2.add(card[i-1]);
        }
        if(i==(card.length-1)){
            card2.add(card[card.length-2]);
            card2.add(card[card.length-1]);
        }

        for (int j = 0; j <card2.size() ; j++) {
            if(j%2==0){
                if(!(card2.get(j).equals("true")||card2.get(j).equals("false")))
                {
                    System.out.println("error");
                    return;
                }
            }else if(!card2.get(j).equals("or")){
                System.out.println("error");
                return;
            }
        }
        System.out.println(card2.contains("true")?"true":"false");
    }

    public static void stackFun(){
        Scanner scanner=new Scanner(System.in);
        String[] ss=scanner.nextLine().split(" ");
        Stack<String> stack=new Stack<>();
        for(int i=0;i<ss.length;i++){
            String curr=ss[i];
            //当前值为true或false时
            if(curr.equals("true")||curr.equals("false")){
                if(stack.isEmpty()){
                    stack.push(curr);
                }else{
                    String top=stack.peek();
                    if(top.equals("true")||top.equals("false")){
                        System.out.println("error");
                        return;
                    }else{
                        if(top.equals("or")) stack.push(curr);
                        else{
                            stack.pop();
                            String pre=stack.pop();
                            if(curr.equals("false")||pre.equals("false")) stack.push("false");
                            else stack.push("true");
                        }
                    }
                }
            }
            //当前值为and或or时
            else{
                if(stack.isEmpty()){
                    System.out.println("error");
                    return;
                }else{
                    String top=stack.peek();
                    if(top.equals("and")||top.equals("or")){
                        System.out.println("error");
                        return;
                    }
                    stack.push(curr);
                }
            }
        }
        if(!stack.isEmpty()&&(stack.peek().equals("or")||stack.peek().equals("and"))){
            System.out.println("error");
            return;
        }
        while(!stack.isEmpty()){
            String curr=stack.pop();
            if(curr.equals("true")){
                System.out.println("true");
                break;
            }
            if(stack.isEmpty()) System.out.println("false");
        }
    }
}
