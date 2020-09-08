package com.cug.qiuzhao.qianxin;

public  class Knapsack {
    private static int[] P={0,5,8};
    private static int[] V={0,5,7};
    private static int T = 10;

    private Integer[][] results = new Integer[P.length + 1][T + 1];


    public void solve2() {
        int result = ks2(P.length - 1,10);
        System.out.println("最大价值为：" + result);
    }

    private int ks2(int i, int t){
        // 如果该结果已经被计算，那么直接返回
        if (results[i][t] != null) return results[i][t];
        int result = 0;
        if (i == 0 || t == 0){
            // 初始条件
            result = 0;
        } else if(V[i] > t){
            // 装不下该珠宝
            result = ks2(i-1, t);
        } else {
            // 可以装下
            // 取k个物品，取其中使得价值最大的
            for (int k = 0; k * V[i] <= t; k++){
                int tmp2 = ks2(i-1, t - V[i] * k) + P[i] * k;
                if (tmp2 > result){
                    result = tmp2;
                }
            }
        }
        results[i][t] = result;
        return result;
    }
}
