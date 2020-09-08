package com.cug.jzOffer.jzOffer3;

public class Question65 {
    public int Add(int num1,int num2) {
        int sum=0;
        do{
            sum=num1^num2;
            num2=(num1&num2)<<1;
            num1=sum;

        }while (num2!=0);
        return sum;
    }
}
