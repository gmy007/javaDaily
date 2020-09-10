package com.cug.qiuzhao.kuaishou;

public class Version {
    class Solution {
        public int compareVersion(String version1, String version2) {
            String[] split1 = version1.split("\\.");
            String[] split2 = version2.split("\\.");
            int i=0,j=0;
            while(i<split1.length && j < split2.length){
                int num1 = Integer.parseInt(split1[i]);
                int num2 = Integer.parseInt(split2[j]);
                if(num1 < num2){
                    return -1;
                }else if(num1 > num2)
                    return 1;
                i++;
                j++;
            }
            while(i>=split1.length && j< split2.length) {
                if(Integer.parseInt(split2[j++]) == 0)
                    continue;
                return -1;
            }
            while(i<split1.length && j>= split2.length) {
                if(Integer.parseInt(split1[i++]) == 0)
                    continue;
                return 1;
            }

            return 0;
        }
    }
}
