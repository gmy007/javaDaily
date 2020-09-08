package com.cug.leetcode;

public class Question1095 {
    interface MountainArray {
      public int get(int index);
      public int length();
  }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l=0,r=mountainArr.length()-1;
        while(l<r){
            int mid=(l+r)>>1;
            if(mountainArr.get(mid)<mountainArr.get(mid+1))
                l=mid+1;
            else r=mid-1;

        }
        int end=l;
        r=l;l=0;
        while(l<=r){
            int mid=(l+r)>>1;
            int cur = mountainArr.get(mid);
            if(cur==target) return mid;
            if(cur>target)
                r=mid-1;
            else l=mid+1;
        }
        l=end;r=mountainArr.length()-1;
        target=-1*target;
        while(l<=r){
            int mid=(l+r)>>1;
            int cur = -1*mountainArr.get(mid);
            if(cur==target) return mid;
            if(cur>target)
                r=mid-1;
            else l=mid+1;
        }
        return -1;
    }
}
