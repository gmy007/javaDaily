package com.cug.jzOffer.jianzhiOffer2;

public class Question51 {
    //逆序对
    public static void main(String[] args) {
        Question51 q = new Question51();
        int[] ints = {7,1,9,2,4};
        int i = q.InversePairs(ints);
        System.out.println(i);
        String s1=" ";


    }
    public int InversePairs(int [] array) {
        if(array==null | array.length==0)
            return 0;
        int[] copy=new int[array.length];
        int count=InversePairsCore(array,copy,0,array.length-1);
        return count;
    }
    public int InversePairsCore(int[] array,int[] copy,int low,int high){
        if(low==high)
            return 0;
        int mid=(low+high)>>1;
        int leftCount=InversePairsCore(array,copy,low,mid);
        int rightCount=InversePairsCore(array,copy,mid+1,high);
        int i=mid,j=high;
        int count=0,locCopy=high;

        while(i>=low && j>mid){
            if(array[i]>array[j]){
                count+=j-mid;
                copy[locCopy--]=array[i--];
                if(count>=1000000007)
                    count%=1000000007;
            }else {
                copy[locCopy--]=array[j--];
            }

        }
        for(;i>=low;i--){
            copy[locCopy--]=array[i];
        }
        for(;j>mid;j--)
        {
            copy[locCopy--]=array[j];
        }
        for(int s=low;s<=high;s++)
        {
            array[s] = copy[s];
        }
        return (leftCount+rightCount+count)%1000000007;
    }
}
