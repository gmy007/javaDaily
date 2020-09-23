package com.cug.leetcode;

public class Demo79 {
    public boolean exist(char[][] board, String word) {
        boolean ret = false;
        for (int i = 0; i < board.length; i++) {
            if(ret) break;
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    char temp = board[i][j];
                    board[i][j] = '.';
                    ret = ret||dfs(board,word,i,j,1);
                    board[i][j]=temp;
                }
            }
        }
        return ret;
    }
    static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
    private boolean dfs(char[][] board, String word, int x, int y,int idx) {
        if(word.length() == idx)
            return true;
        boolean ret = false;
        for (int i = 0; i < 4; i++) {
            int row = x+move[i][0];
            int col = y+move[i][1];
            if(row<0 || col<0 || row>=board.length|| col>=board[0].length)
                continue;
            char temp = board[row][col];
            if(board[row][col] == word.charAt(idx)){
                board[row][col] = '.';
                ret = ret ||dfs(board,word,row,col,idx+1);
            }
            board[row][col]=temp;
        }
        return ret;

    }
}
