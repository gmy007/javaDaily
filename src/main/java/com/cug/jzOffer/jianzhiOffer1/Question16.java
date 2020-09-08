package com.cug.jzOffer.jianzhiOffer1;

public class Question16 {
    public double Power(double base, int exponent) {

        if(exponent==0)
            return 1;
        int n;
        double res=1;
        if(exponent<0)
            n=-exponent;
        else n=exponent;
        while(n!=0){
            if((n&1)==1){
                res*=base;
            }
            base*=base;
            n=n>>1;
        }
        return exponent>0?res:1/res;
        /*
        整数快速幂
         */
    }
}
