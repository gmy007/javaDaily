package com.cug.leetcode;

public class Demo6 {
    public String convert(String s, int numRows) {
        StringBuffer[] sbs = new StringBuffer[numRows];
        int count =0;
        int n = s.length();
        int i = 0,move = 1;
        while(count<n){
            if(null == sbs[i])
                sbs[i] = new StringBuffer();
            sbs[i].append(s.charAt(count));
            i+=move;
            if(i>=numRows-1)
                move = -1;
            if(i <=0)
                move = 1;
            count++;
        }
        StringBuffer ret = new StringBuffer();
        for (int j = 0; j < numRows; j++) {
            if(null ==sbs[j] )
                break;
            ret.append(sbs[j].toString());
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Demo6().convert("LEETCODEISHIRING", 3 ));
        //LCIRETOESIIGEDHN
        //LCIRETOESIIGEDHN

    }
}
