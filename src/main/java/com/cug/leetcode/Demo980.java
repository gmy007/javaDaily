package com.cug.leetcode;

public class Demo980 {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger>=desiredTotal)
            return true;
        if((1+maxChoosableInteger)*maxChoosableInteger/2 < desiredTotal)
            return false;
        Boolean[] flag = new Boolean[1 << maxChoosableInteger];
        return dfs(maxChoosableInteger,desiredTotal,0,flag);
    }
    /*
    使用state保存1到maxchoose的使用状态。
    state = (1<<(i-1))|state;
    1<<(i-1) 为当前使用的数的状态，按位表示。
     */
    public boolean dfs(int maxChoosableInteger,int desiredTotal,int state,Boolean[] flag){
        if(flag[state]!=null)
            return flag[state];
        for (int i = 1; i <=maxChoosableInteger ; i++) {
            int cur = 1<<(i-1);
            if((cur&state)==0){
                if(desiredTotal-i<=0 || !dfs(maxChoosableInteger,desiredTotal-i,cur|state,flag)){
                    flag[state]=true;
                    return true;
                }
            }

        }
        flag[state] = false;
        return false;
    }
}
