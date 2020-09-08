package com.cug.leetcode.mianshijindian;

public class demo8
{
    /**
     * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
     * 输入：
     * [
     *   [0,1,2,0],
     *   [3,4,5,2],
     *   [1,3,1,5]
     * ]
     * 输出：
     * [
     *   [0,0,0,0],
     *   [0,4,5,0],
     *   [0,3,1,0]
     * ]
     *
     * 解法：使用第一行记录当前列是否要删除，遍历时先记录到 0行J列是否删除，再用布尔类型记录当前行是否删除，需要删除则删除，
     * 判断完后再处理第一行是否删除
     */
    public void setZeroes(int[][] matrix) {
        int row=matrix.length,col=matrix[0].length;
        boolean del1st=false,delCur=false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j]==0){
                    if(i==0){
                        del1st=true;
                        matrix[i][j]=0;
                    }
                    else {
                        matrix[0][j]=0;
                        delCur=true;
                    }
                }
            }
            if(i!=0&&delCur){
                matrix[i]=new int[col];
                delCur=false;
            }

        }

        for (int i = 0; i < col; i++) {
            if(matrix[0][i]==0){
                for (int j = 1; j < row; j++) {
                        matrix[j][i]=0;
                }
            }

        }
        if(del1st){
            for (int i = 0; i < col; i++) {
                matrix[0][i]=0;
            }
        }
    }
}
