package com.cug.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Question542 {
    static int[][] move={{-1,0},{0,-1},{1,0},{0,1}};
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0)
                    queue.offer(new int[]{i,j});
                else matrix[i][j]=-1;
            }
        }
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int[] ints : move) {
                int newX=cur[0]+ints[0];
                int newY=cur[1]+ints[1];
                if(newX>=0 && newY>=0 && newX<m && newY<n && matrix[newX][newY]==-1){
                    matrix[newX][newY]=matrix[cur[0]][cur[1]]+1;
                    queue.offer(new int[]{newX,newY});
                }
            }
        }
        return matrix;

    }

}
