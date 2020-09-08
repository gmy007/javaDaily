package com.cug.jzOffer.jianzhiOffer1;

public class Question11 {
    public static void main(String[] args) {
        int[] a={4,5,6,7,8,9,0,1,2,3};
        new Question11().minNumberInRotateArray(a);
        System.out.println(a);
    }
    public int minNumberInRotateArray(int [] array) {

        if(array.length==0)
            return 0;
        int l=0;
        int h=array.length-1;
        while(l<h){
            int m=l+(h-1)/2;
            if(array[l]==array[m]&&array[m]==array[h])
                return minNumber(array,l,h);
            else if(array[m]<array[h]){
                h=m;
            }else
                l=m+1;
        }
        return array[l];
    }
    private int minNumber(int[] nums, int l, int h) {
        for (int i = l; i < h; i++)
            if (nums[i] > nums[i + 1])
                return nums[i + 1];
        return nums[l];
    }
}
