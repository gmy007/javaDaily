package com.cug.leetcode.mianshijindian;

public class demo7 {
    /**
     * 旋转矩阵
     * 给定一幅由N × N矩阵表示的图像，其中每个像素的大小为4字节，编写一种方法，将图像旋转90度。
     * 不占用额外内存空间能否做到？
     */
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(a);
    }

    /**
     * 异或交换
     * a=a^b
     * b=a^b;
     * a=a^b；
     *
     *
     */
    public void roa(int[][] mat){
        int N=mat.length;
        //先把矩阵斜对角线交换，斜向左下

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j <N ; j++) {
                mat[i][j]^=mat[j][i];
                mat[j][i]=mat[i][j]^mat[j][i];
                mat[i][j]=mat[i][j]^mat[j][i];
                
            }
        }

        //再把列对应交换  1--n-1  2--n-2……以此类推就能把矩阵顺时针九十度
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N/2; j++) {
                mat[i][j]=mat[i][j]^mat[i][N-j-1];
                mat[i][N-j-1]=mat[i][j]^mat[i][N-j-1];
                mat[i][j]=mat[i][j]^mat[i][N-j-1];

            }
            
        }
        
    }
    public static void rotate(int[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                int swap = matrix[i][j];
                matrix[i][j] = matrix[size - j - 1][size - i - 1];
                matrix[size - j - 1][size - i - 1] = swap;
            }
        }
        for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < size; j++) {
                int swap = matrix[i][j];
                matrix[i][j] = matrix[size - i - 1][j];
                matrix[size - i - 1][j] = swap;
            }
        }
    }



}
