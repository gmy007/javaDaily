package com.cug.trueTest.wanmeishijie;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list1.add(sc.next());
        }
        int m=sc.nextInt();
        for (int i = 0; i < m; i++) {
            list2.add(sc.next());
        }
        int j=0,i=Integer.MIN_VALUE;
        int ret=0;
        while(j<m){
            Iterator<String> iterator = list1.iterator();
            while(iterator.hasNext()){
                i=Math.max(i,list2.indexOf(iterator.next()));
                if(i==-1){
                    break;
                }
            }
            if(i==-1)break;
            list2 = list2.subList(i, list2.size());
            j=i;
            i=Integer.MIN_VALUE;
            ret++;
        }
        System.out.println(ret);
    }
    public static  void fun(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, Integer> nArr = new HashMap<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            nArr.put(sc.next(), i);
        }

        int m = sc.nextInt();
        String[] mArr = new String[m];

        for (int i = 0; i < m; i++) {
            mArr[i] = sc.next();
        }

        int count = 0;
        int res = 0;

        for (int i = 0; i < m; i++) {
            if (nArr.containsKey(mArr[i])) {
                if (!visited[nArr.get(mArr[i])]) {
                    visited[nArr.get(mArr[i])] = true;
                    count++;
                }
            }
            if (count == n) {
                res++;
                count = 0;
                for (int j = 0; j < n; j++) {
                    visited[j] = false;
                }
                nArr.remove(mArr[i]);
                if (nArr.size() == 0) {
                    res = -1;
                    break;
                }
            }
        }

        System.out.println(res);
    }
}
