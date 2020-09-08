package com.cug.mianshi.douyu;

public class Main1 {
    public int compareVersion (String version1, String version2) {
        // write code here
        String[] v1 = version1.split(".");
        String[] v2 = version2.split(".");
        if(v1.length!=0&&v2.length!=0){
            int l1 = v1.length;
            int l2 = v2.length;
            int max = Math.max(l1, l2);
            int i=0,j=0;
            while(i<max){
                if(i>=l1&&i<l2)
                    return -1;
                if(i>=l2&&i<l1)
                    return 1;
                if(Integer.valueOf(v1[i])<Integer.valueOf(v2[i])){
                    return -1;
                }else if(Integer.valueOf(v1[i])>Integer.valueOf(v2[i])){
                    return 1;
                }else {
                    i++;
                }
            }
        }else {

        }

        return 0;
    }
}
