package com.cug.sort;

public class InsertSort {
    private static int[] insert(int[]arr){
        if(arr == null || arr.length < 2){
            return arr;
        }
        for(int i=1;i<arr.length;i++){
            int temp = arr[i];
            int indx = 0;
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    arr[j] = arr[j-1];
                    indx = j-1;
                }else{
                    break;
                }
                arr[indx]=temp;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] a={-2,1,5,2,3};
        insertSort(a);
        //System.currentTimeMillis();
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }

    }
    public static void insertSort(int[] nums){
        int length = nums.length;
        for (int i = 1; i <length ; i++) {
            for (int j = i; j >0 ; j--) {
                if(nums[j]<nums[j-1])
                {
                    int temp=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=temp;
                }else break;//如果第一个就大了，那后面都不用比，始终保持0-i之间有序
            }
        }
    }
}
