package com.cug.TecentPra;

import java.util.Scanner;

public class demo1 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String rec=sc.nextLine();
        int index1=0;
        int index2=0;
        int num=0;
        String str="";
        String str2="";
        for(int i=rec.length()-1; i>=0;i--){
            char c=rec.charAt(i);
            if(c=='['){
                index1=i;
                for(int j=i+2;j<rec.length();j++){
                    //System.out.println(j);
                    char shu=rec.charAt(j);
                    if(shu=='|'){
                        //System.out.println(j+"  "+i);
                        num=Integer.parseInt(rec.substring(i+1,j));
                        index2=j;
                        j=j+1;
                        continue;
                    }
                    if(shu==']'){
                        str=rec.substring(index2+1,j);
                        str2="";
                        for (int k = 0; k <num ; k++) {
                            str2+=str;
                        }
                        //System.out.println("["+num+"|"+str+"]"+"    "+str2);
                        rec=rec.replace("["+num+"|"+str+"]",str2);
                        //System.out.println(rec);
                        break;
                    }
                }
            }
        }
        System.out.println(rec);
    }

}
