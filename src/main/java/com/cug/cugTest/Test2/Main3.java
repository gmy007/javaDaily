package com.cug.cugTest.Test2;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] matrix=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        int count=0;
        while(count<(n+m-1)){
            if(count%2==1){
                int i=0,j=count-i;
                while(j>=m){j--;i++;}
                for (;i<=count&&i<n;i++,j--) {
                    System.out.print(matrix[i][j]+" ");
                }
            }else{
                int j=0,i=count-j;
                while(i>=n){j++;i--;}
                for (;j<=count&&j<m;j++,i--) {
                    System.out.print(matrix[i][j]+" ");
                }
            }
            count++;
        }
    }
}
