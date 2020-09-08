package com.cug.leetcode;

public class Question28 {
    public static void main(String[] args) {
        System.out.println(new Question28().new Solution().strStr("hello", "ll"));

    }
    class Solution {
        public int strStr(String haystack, String needle) {
            if(needle.length()==0)
                return 0;

            char[] char1=haystack.toCharArray();
            char[] char2=needle.toCharArray();
            for(int i=0;i<char1.length;i++){
                for(int j=i;j<char2.length;j++){
                    if(char1[j]!=char2[j])
                        break;
                    else if(j==char2.length-1)
                            return i;
                }
            }
            return -1;
        }
    }
    public void rotate(int[] nums, int k) {
        k=k&nums.length;
        int n=nums.length;
        int count =0;
        for(int i=0;count<n;i++){
            int start=i;
            int pre=nums[i];
            do{
                int next=(start+k)%n;
                int temp=nums[next];
                nums[next]=pre;
                pre=temp;
                start=next;
                count++;
            }while(i!=start);
        }
    }
}
