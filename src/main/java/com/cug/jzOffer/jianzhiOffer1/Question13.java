package com.cug.jzOffer.jianzhiOffer1;

public class Question13 {

    //
    public int movingCount(int threshold, int rows, int cols)
    {
        int count=0;
        boolean[][] visited=new boolean[rows][cols];

        count=movingCount(threshold,rows,cols,0,0,visited);
        return count;

    }
    public int movingCount(int threshold,int rows,int cols,int r,int c,boolean[][] visited){
        int count=0;
        if(check(threshold,rows,cols,r,c,visited)){
            visited[r][c]=true;
            count=1+movingCount(threshold,rows,cols,r-1,c,visited)+movingCount(threshold,rows,cols,r+1,c,visited)
            +movingCount(threshold,rows,cols,r,c-1,visited)+movingCount(threshold,rows,cols,r,c+1,visited);
        }
        return count;
    }
    public boolean check(int threshold,int rows,int cols,int r,int c,boolean[][] visited){

        if(r<0 || r>=rows || c<0 || c>=cols ||visited[r][c]||getDigitSum(r)+getDigitSum(c)>threshold)
            return false;
        return true;
    }
    public int getDigitSum(int a){
        int sum=0;
        while(a>0){
            sum+=a%10;
            a/=10;
        }
        return sum;
    }

    /*
        private static final int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        private int cnt = 0;
        private int rows;
        private int cols;
        private int threshold;
        private int[][] digitSum;

        public int movingCount(int threshold, int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            this.threshold = threshold;
            initDigitSum();
            boolean[][] marked = new boolean[rows][cols];
            dfs(marked, 0, 0);
            return cnt;
        }

        private void dfs(boolean[][] marked, int r, int c) {
            if (r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c])
                return;
            marked[r][c] = true;
            if (this.digitSum[r][c] > this.threshold)
                return;
            cnt++;
            for (int[] n : next)
                dfs(marked, r + n[0], c + n[1]);
        }

        private void initDigitSum() {
            int[] digitSumOne = new int[Math.max(rows, cols)];
            for (int i = 0; i < digitSumOne.length; i++) {
                int n = i;
                while (n > 0) {
                    digitSumOne[i] += n % 10;
                    n /= 10;
                }
            }
            this.digitSum = new int[rows][cols];
            for (int i = 0; i < this.rows; i++)
                for (int j = 0; j < this.cols; j++)
                    this.digitSum[i][j] = digitSumOne[i] + digitSumOne[j];
        }
     */
}
