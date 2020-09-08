package com.cug.leetcode.mianshijindian;

public class Demo0502 {
    public String printBin(double num) {
        StringBuffer sb = new StringBuffer();
        sb.append("0.");
        while (num != 0) {
            num*=2;
            if(num>=1){
                sb.append(1);
                num-=1;

            }else
                sb.append(0);
            if(sb.length()>32)
                return "ERROR";

        }
        return sb.toString();
    }
}
