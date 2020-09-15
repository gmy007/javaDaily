package com.cug.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Demo54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ret;
        }
        int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};
        int m = matrix.length;
        int n =matrix[0].length;
        int total = m * n;
        int row =0,col=0;
        int direction = 0;
        boolean[][] flag = new boolean[m][n];
        for(int i = 0;i<total;i++){
            ret.add(matrix[row][col]);
            int newX = row+move[direction][0];
            int newY = col+move[direction][1];
            flag[row][col] = true;
            if(newX < 0|| newY < 0 || newX>=m || newY >= n || flag[newX][newY]){
                direction = (direction+1)% 4;
            }
            row = row + move[direction][0];
            col = col + move[direction][1];
        }
        return ret;
    }
}
