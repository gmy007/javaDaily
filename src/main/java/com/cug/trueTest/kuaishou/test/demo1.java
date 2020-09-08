package com.cug.trueTest.kuaishou.test;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class demo1 {
    private  static Set<Integer>[] adj;
    static int mod=1000000007;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt();
        adj=new HashSet[n+1];
        visited=new boolean[n+1];
        long bad=0;
        for (int i = 1; i <=n ; i++) {
            adj[i]=new HashSet<>();
        }
        for (int i = 0; i < n-1; i++) {
            int a=sc.nextInt(),b=sc.nextInt(),weight=sc.nextInt();
            if(weight==0){
                adj[a].add(b);
                adj[b].add(a);
            }
        }
        for (int i = 1; i <=n ; i++) {
            if(!visited[i]){
                bad=(bad+getMod(dfs(i),k))%mod;
            }
        }
        System.out.println((getMod(n,k)+mod-bad)%mod);
    }

    private static int dfs(int num) {

        visited[num]=true;
        int res=1;
        for (Integer i : adj[num]) {
            if(!visited[i])res=res+dfs(i);
        }
        return res;
    }

    public static long getMod(long a, long b){
        long sum = 1;
        a %= mod;
        while(b>0){
            if(b%2 == 1)
                sum = (sum*a)%mod;
            b /= 2;
            a = (a*a)%mod;
        }
        return sum;
    }
    public static BigInteger fastPow(int n,int k){
        if(k==0) return new BigInteger("1");
        BigInteger half=fastPow(n,k/2);
        if(k%2==0) return half.multiply(half).mod(new BigInteger(""+mod));
        else return half.multiply(half).multiply(new BigInteger(""+n)).mod(new BigInteger(""+mod));
    }
}
