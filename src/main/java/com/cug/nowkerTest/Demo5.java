package com.cug.nowkerTest;

import java.util.Stack;

public class Demo5 {
    //大鱼吃小鱼，牛客

    public int solve (int N, int[] A) {
        // write code here
        Stack<Integer> s = new Stack<>();
        int[] F=new int[N+1];
        int ret=0;
        for (int i = 0; i < N; i++) {
            if(s.isEmpty()){
                s.push(A[i]);
                continue;
            }
            int maxn=0;
            while(!s.isEmpty()&& s.peek()<A[i]){
                maxn=Math.max(maxn,F[s.peek()]);
                s.pop();
            }
            s.push(A[i]);
            if(s.size()==1)continue;
            F[A[i]]=maxn+1;
            ret=Math.max(ret,F[A[i]]);
        }
        return ret;
    }
}
