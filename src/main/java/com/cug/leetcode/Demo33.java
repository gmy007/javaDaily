package com.cug.leetcode;

public class Demo33 {
    public static void main(String[] args) {
        System.out.println(new Demo33().search(new int[]{1, 3}));
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0)
            return -1;
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid ] ==target)
                return mid;
            if(nums[mid]>nums[l]){
                if(target<nums[mid])
                    r=mid-1;
                else
                    l=mid+1;
            }else if(nums[mid] < nums[r]){
                if(target>nums[mid])
                    l=mid+1;
                else
                    r=mid-1;
            }

        }
        return -1;
    }

    public int search(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > nums[i] && nums[mid] > nums[j]) {
                i = mid + 1;
            } else if (nums[mid] < nums[i] && nums[mid] < nums[j]) {
                if (nums[mid] < nums[mid - 1]) {
                    i = mid;
                    break;
                } else
                    j = mid - 1;
            } else if (nums[mid] > nums[i] && nums[mid] < nums[j])
                j = mid - 1;
        }
        return i;
    }

    public int binsearch(int nums[], int i, int j, int target) {
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < target)
                i = mid + 1;
            else if (nums[mid] > target)
                j = mid - 1;
            else
                return mid;
        }
        return -1;
    }


}
