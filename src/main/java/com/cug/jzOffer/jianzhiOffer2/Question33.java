package com.cug.jzOffer.jianzhiOffer2;

public class Question33 {
    public boolean VerifySquenceOfBST(int [] sequence) {

        if(sequence==null || sequence.length<=0)
            return false;
        return verify(sequence,0,sequence.length-1);
    }
    public boolean verify(int [] seq,int first,int last){
        if(last-first<=1)
            return true;
        int rootVal=seq[last];
        int curIndex=first;
        while(curIndex<last && seq[curIndex]<=rootVal){
            curIndex++;
        }
        for (int i = curIndex; i <last ; i++) {
            if(seq[i]<rootVal)
                return false;

        }
        return verify(seq,first,curIndex-1)&&verify(seq,curIndex,last-1);
    }
}
