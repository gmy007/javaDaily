package com.cug.jzOffer.jianzhiOffer1;

import java.util.Set;
import java.util.TreeMap;

public class Question3 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public static void main(String[] args) {
        int[] a={2,1,3,1,4};
        int[] b=new int[200];

        System.out.println(new Question3().duplicate(a,5,b));
        for (int i = 0; i < b.length; i++) {
            if(b[i]==0)
                continue;
            System.out.println(b[i]);
        }
    }
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length==0 || numbers==null){
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int i=0;i<length;i++){
            if(!map.containsKey(numbers[i]))
                map.put(numbers[i],1);
            else
                map.put(numbers[i],map.get(numbers[i])+1);

        }
        Set<Integer> keySet = map.keySet();

        for(Integer i:keySet){
            if(map.get(i)>1){
                duplication[0]=i;
                break;
            }
        }
        if(duplication[0]==-1)
            return false;
        return true;
    }
    public boolean answer(int numbers[],int length,int [] duplication) {

        if(length==0 || numbers==null){
            return false;
        }

        for (int i = 0; i < length; i++) {
            while(numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]]){
                    duplication[0]=numbers[i];
                    return true;
                } swap(numbers,i,numbers[i]);
            }
        }
        return false;
    }
    private void swap(int[] num,int a,int b){
        int temp=num[a];
        num[a]=num[b];
        num[b]=temp;

    }
}
