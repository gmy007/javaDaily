package com.cug.jzOffer.jianzhiOffer2;

public class Question47 {
    public int getMost(int[][] board) {
        // write code here
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                if(i==0&& j==0){

                }else if(i==0){
                    board[i][j]+=board[i][j-1];
                }else if(j==0){
                    board[i][j]+=board[i-1][j];
                }else {
                    board[i][j]+=Math.max(board[i][j-1],board[i-1][j]);
                }

            }
            
        }
        return board[board.length-1][board[0].length-1];
    }
}
