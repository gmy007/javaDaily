package com.cug.TecentPra;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        if(s==null|| s.length()==0)
            System.out.print("");
        if(!s.contains("["))
            System.out.print(s);
        else{

            System.out.print(jieyasuo(s,0,s.length()-1));
        }
    }
    public static String jieyasuo(String s,int start,int end){
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        boolean firstPre=false;
        int newStr=-1,newEnd=-1;
        if(chars[start]!='['||chars[end]!=']'){
            for (int i = 0; i <s.length() ; i++) {
                if(!firstPre&& s.charAt(i)=='[')
                {
                    start=i;
                    firstPre=true;
                }
                if(s.charAt(i)==']')
                    end=i;
            }
        }

        firstPre=false;
        for (int i = start+1; i <end ; i++) {
            if(!firstPre && chars[i]=='[')
            {
                newStr=i;
                firstPre=true;
            }
            if(chars[i]==']')
                newEnd=i;
        }
        if(newEnd==-1&&newStr==-1){
            int numIndex=-1;
            for (int i = start; i <end ; i++) {
                if(chars[i]=='|')
                    numIndex=i;
            }
            if(numIndex==-1)
                return s;
            int num = Integer.parseInt(s.substring(start+1, numIndex));
            String substring = s.substring(numIndex + 1, end );
            sb.append(s.substring(0,start));
            for (int i = 0; i <num ; i++)
                sb.append(substring);
            sb.append(s.substring(end==s.length()?end:end+1,s.length()));
            return sb.toString();
        }else{
            String newString =jieyasuo(s,newStr,newEnd);
            return jieyasuo(newString,0,newString.length()-1);
        }



    }

}