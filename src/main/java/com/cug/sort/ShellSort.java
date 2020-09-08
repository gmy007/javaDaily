package com.cug.sort;

public class ShellSort {
    public static void main(String[] args) {
        int[] a={-2,1,5,2,3};
        shellSort(a);
        System.currentTimeMillis();
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }

    }
    public static void shellSort(int[] nums){
        int length = nums.length;
        int gap=length>>1;
        while(gap>0){
            for (int i = 0; i <gap ; i++) {
                for (int j = i+gap; j <length ; j+=gap) {
                    // 如果a[j] < a[j-gap]，则寻找a[j]位置，并将后面数据的位置都后移。
                    if (nums[j] < nums[j - gap]) {
                        int temp = nums[j];
                        int k = j - gap;
                        while (k >= 0 && nums[k] > temp) {
                            nums[k + gap] = nums[k];
                            k -= gap;
                        }
                        nums[k + gap] = temp;
                    }
                }
            }
            gap=gap>>1;
        }

    }
}
