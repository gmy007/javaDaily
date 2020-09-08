package com.cug.jzOffer.jzOffer3;

public class Question66 {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0,ret=1; i <A.length ; i++) {
            B[i]=ret;
            ret*=A[i];
        }
        for (int i = A.length-1,ret=1; i >=0 ; i--) {
            B[i]*=ret;
            ret*=A[i];
        }
        return B;

    }
}
