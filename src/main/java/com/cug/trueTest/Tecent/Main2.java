package com.cug.trueTest.Tecent;

import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        while(n-->0){
            int q=sc.nextInt();
            double[][] A=new double[q][2];
            double[][] B=new double[q][2];
            for (int i = 0; i < q; i++) {
                A[i][0]=sc.nextDouble();
                A[i][1]=sc.nextDouble();
            }
            for (int i = 0; i < q; i++) {
                B[i][0]=sc.nextDouble();
                B[i][1]=sc.nextDouble();
            }
            double min=Double.MAX_VALUE;
            for (int i = 0; i < q; i++) {
                for (int j = 0; j < q; j++) {
                    min=Math.min(min,Math.pow(Math.pow(A[i][0]-B[j][0],2)+Math.pow(A[i][1]-B[j][1],2),0.5));
                }
            }
            System.out.println(String.format("%.3f",min));
        }
    }

}
