package com.cug.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Question200 {
    public int numIslands(char[][] grid) {
        if(grid.length==0||grid[0].length==0)
            return 0;
        int m = grid.length;
        int n=grid[0].length;
        boolean[][] visit=new boolean[m][n];
        int count=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid,int r,int c){
        int m = grid.length;
        int n=grid[0].length;
        if(r<0 || c<0 || r>=m || c>=n || grid[r][c]=='0'){
            return;
        }
        grid[r][c]='0';
        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
    }

    public int bfs(char[][] grid){
        if(grid.length==0||grid[0].length==0)
            return 0;
        int m = grid.length;
        int n=grid[0].length;
        int count=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]=='1'){
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(i*n+j);
                    count++;
                    while(!queue.isEmpty()){
                        Integer cur = queue.poll();
                        int r=cur/n;
                        int c=cur%n;
                        if(r-1>=0&&grid[r-1][c]=='1'){
                            queue.offer((r-1)*n+c);
                            grid[r-1][c]='0';
                        }
                        if(c-1>=0&&grid[r][c-1]=='1'){
                            queue.offer(r*n+c-1);
                            grid[r][c-1]='0';
                        }
                        if(r+1<m&&grid[r+1][c]=='1'){
                            queue.offer((r+1)*n+c);
                            grid[r+1][c]='0';
                        }
                        if(c+1<n&&grid[r][c+1]=='1'){
                            queue.offer(r*n+c+1);
                            grid[r][c+1]='0';
                        }
                    }
                }
            }
        }
        return count;
    }

}
