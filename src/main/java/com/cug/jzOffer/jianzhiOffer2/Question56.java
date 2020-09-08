package com.cug.jzOffer.jianzhiOffer2;

public class Question56 {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int diff=0;
        for(int num : array)
            diff^=num;
        //diff&=-diff;//得出最右侧不为0的位，也就是不存在重复的两个元素不同的最右位。
        int flag=1;
        while((diff&flag)==0)flag<<=1;
        for(int num :array){
            //根据位不同分组
            if((num&diff)==0)
                num1[0]^=num;
            else num2[0]^=num;
        }

    }
}
