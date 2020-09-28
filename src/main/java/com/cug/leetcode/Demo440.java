package com.cug.leetcode;

public class Demo440 {
    //思路：转换为10叉树的前序遍历的第K的节点
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k=k-1;
        while(k>0){
            int num = getNode(n,cur,cur+1);
            if(num <=k){
                cur+=1;
                k-=num;
            }else {
                cur*=10;
                k-=1;
            }
        }
        return cur;
    }
    //得到当前节点下的所有节点个数。
    public int getNode(int n,long str,long end){
        int num = 0;
        while(str <=n){
            num += Math.min(n+1,end)-str;
            str*=10;
            end*=10;
        }
        return num;
    }
}
