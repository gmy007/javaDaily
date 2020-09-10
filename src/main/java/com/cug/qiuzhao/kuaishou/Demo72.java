package com.cug.qiuzhao.kuaishou;

public class Demo72 {
    /**
     * 编辑距离
     * 两个单词相互转换最少要几步
     * 可以增加
     * 删除
     * 修改
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(n*m == 0)
            return n+m;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int left = dp[i-1][j]+1;
                int down = dp[i][j-1]+1;
                int left_down = dp[i-1][j-1];
                if(word1.charAt(i-1) != word2.charAt(j-1))
                    left_down++;
                dp[i][j]= Math.min(left,Math.min(down,left_down));

            }
        }
        return dp[n][m];

    }
}
