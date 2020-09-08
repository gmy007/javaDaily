package com.cug.trueTest.jingdong;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Main1 {
    static class Rec{
        int w;
        int l;
        public Rec(int w,int l){
            this.w=w;
            this.l=l;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Rec rec = (Rec) o;
            return (w == rec.w && l == rec.l) ||
                    (w == rec.l && l == rec.w);
        }

        @Override
        public int hashCode() {
            return Objects.hash(w, l);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        Rec[][] recs = new Rec[T][6];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 6; j++) {
                recs[i][j]=new Rec(sc.nextInt(),sc.nextInt());
            }
            System.out.println(isRecTi(recs[i])?"POSSIBLE":"IMPOSSIBLE");
        }

    }
    public static boolean isRecTi(Rec[] recs){
        for (int i = 0; i < recs.length-1; i++) {
            if(null==recs[i]) continue;
            Rec cur=recs[i];
            for (int j = i+1; j <recs.length ; j++) {
                if(null!=recs[j] &&cur.equals(recs[j])){
                    recs[i]=null;
                    recs[j]=null;
                    break;
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            if(recs[i]!=null)
                return false;
        }

        return true;

    }
}
