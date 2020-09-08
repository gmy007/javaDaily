package com.cug.demo;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),head=sc.nextInt();

        int[][] nodes=new int[n][3];
        for (int i = 0; i < n; i++) {
            nodes[i][0]=sc.nextInt();
            nodes[i][1]=sc.nextInt();
            nodes[i][2]=sc.nextInt();

        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            System.out.println(findFather(nodes,sc.nextInt(),sc.nextInt()));
        }
    }
    public static int findFather(int[][] nodes,int node1,int node2){
        if(node1==node2)
            return node1;
        for (int i = 0; i < nodes.length; i++) {
            if ((nodes[i][1] == node1 && nodes[i][2]==node2)||(nodes[i][2] == node1 && nodes[i][1]==node2)) {
                return nodes[i][0];
            }else {
                if(nodes[i][1]==node1||nodes[i][2]==node1){
                    return findFather(nodes,nodes[i][0],node2);
                }
                if(nodes[i][1]==node2||nodes[i][2]==node2)
                    return findFather(nodes,nodes[i][0],node1);
            }

        }
        return  0;
    }
}
