package com.cug.nowkerTest;

import java.util.*;
public class Main3{
    private static class person {
        int f;
        int q;
        public person(int f,int q){
            this.f=f;
            this.q=q;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<person> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int f=sc.nextInt();
            int q=sc.nextInt();
            list.add(new person(f,q));
        }
        Collections.sort(list,(o1, o2) -> {
            if(o1.f==o2.f)
                return o1.q-o2.q;
            return o1.f-o2.f;
        });
        int max=0,cha=0;
        long res=0;
        int index=0;
        for (int i = 0; i < n; i++) {
            if(list.get(i).f+list.get(i).q>=max || list.get(i).f+list.get(i).q+cha>=max){
                max=list.get(i).f+list.get(i).q;
                cha=list.get(i).q-list.get(i).f;
                index=i;
            }
        }
        for (int i = index-1; i >= 0 ; i--) {
            if (list.get(index).f!=list.get(i).f&&list.get(i).q > list.get(i).f) {
                res += list.get(i).q -list.get(i).f;
            }
        }

        System.out.println(res+max);


    }

}
