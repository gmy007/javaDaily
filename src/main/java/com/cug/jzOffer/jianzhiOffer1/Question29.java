package com.cug.jzOffer.jianzhiOffer1;

import java.util.ArrayList;

public class Question29 {
    /*
    顺时针打印矩阵
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int rows=matrix.length-1;
        int cols=matrix[0].length-1;
        int r1=0 ,c1=0;
        ArrayList<Integer> result = new ArrayList<>();
        while(r1<=rows && c1<=cols){
            for (int i = c1; i <=cols ; i++) {
                result.add(matrix[r1][i]);
            }
            for (int i = r1+1; i <=rows ; i++) {
                result.add(matrix[i][cols]);
            }
            if(r1!=rows)
                for (int i = cols-1; i >=c1 ; i--) {
                    result.add(matrix[rows][i]);
                }
            if(c1!=cols)
                for (int i = rows-1; i>r1  ; i--) {
                    result.add(matrix[i][c1]);
                }

            r1++;rows--;c1++;cols--;
        }
        return result;
    }
}
