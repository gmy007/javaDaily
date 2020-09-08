package com.cug.demo0726;

public class demo1 {


    public void printAllSubString(String str,int idx,String cur){

        if(idx == str.length()){
            System.out.println(cur.length()==0?"":cur);
            return;
        }
        printAllSubString(str,idx+1,cur+String.valueOf(str.charAt(idx)));
        printAllSubString(str,idx+1,cur);

    }

    public static void main(String[] args) {
        demo1 d = new demo1();
        d.printAllSubString("abc",0,"");
        System.out.println(d.birthCow(6));
    }
    /*
    母牛每年生一只，新出生的三年成熟后也会生，求第N年的牛
     */
    public int birthCow(int N){
        if(N<=0){
            return 0;
        }
        if(N<=4){
            return N;
        }
        return birthCow(N-1)+birthCow(N-3);
    }
}
