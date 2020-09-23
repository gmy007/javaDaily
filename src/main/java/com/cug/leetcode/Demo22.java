package com.cug.leetcode;
import java.util.*;
public class Demo22 {
    public List<String> generateParenthesis(int n) {
        ret = new ArrayList<String>();
        doGenerate(n,0,0,new StringBuilder());
        return ret;
    }
    static List<String> ret;
    public void doGenerate(int n, int pre,int end,StringBuilder sb){
        if(pre == n&& end == n){
            ret.add(sb.toString());
            return;
        }
        if(pre <n){
            sb.append("(");
            doGenerate(n,pre+1,end,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(end<pre){
            sb.append(")");
            doGenerate(n,pre,end+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
