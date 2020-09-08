package com.cug.leetcode.mianshijindian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Demo16_19 {
    public int[] pondSizes(int[][] land) {
        ArrayList<Integer> list = new ArrayList<>();
        int direct[][]= {{1,0}, {1,1}, {0,1}, {-1,1},
                {-1,0},{-1,-1},{0,-1}, {1, -1}};
        int row = land.length;
        if(row<=0){ return null;}
        int col = land[0].length;
        if(col<=0){ return null;}
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(land[i][j]==0){
                    land[i][j]=1;
                    int size=0;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i*col+j);
                    while(!queue.isEmpty()){
                        Integer popElement = queue.remove();
                        int index_i = popElement/col;
                        int index_j = popElement%col;
                        for (int pos = 0; pos < 8; pos++) {
                            int newX=index_i+direct[pos][0];
                            int newY=index_j+direct[pos][1];
                            if(newX>=0 && newX<row && newY>=0 && newY<col &&land[newX][newY]==0)
                            {
                                size++;
                                queue.add(newX*col+newY);
                                land[newX][newY]=1;
                            }
                        }

                    }
                    list.add(size);
                }

            }

        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i]=list.get(i);
        }
        Arrays.sort(ret);
        return ret;
    }
}
