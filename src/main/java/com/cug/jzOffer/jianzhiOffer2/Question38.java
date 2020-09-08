package com.cug.jzOffer.jianzhiOffer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Question38 {

    public static void main(String[] args) {
        Question38 q = new Question38();
        q.Permutation("abc");
        String s = q.ret.get(0);
        for (int i = 0; i <q.ret.size() ; i++) {
            System.out.println(q.ret.get(i).toString());

        }
    }
    private ArrayList<String> ret=new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if(str.length()==0)
            return ret;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        Permutation(chars,0);
        Collections.sort(ret);//保证输出的各个字符串顺序也是字典序，Collections类调用的集合中存储元素实现Compareto方法
        return ret;
    }


    public void Permutation(char[] str ,int begin){
        if(begin==str.length){
            ret.add(new String(str));
            return;
        }
        for (int i = begin; i <str.length ; i++) {
            if(i!=begin && str[i]==str[begin])
                continue;
            char temp = str[begin];
            str[begin]=str[i];
            str[i]=temp;
            Permutation(str,begin+1);
            temp = str[begin];
            str[begin]=str[i];
            str[i]=temp;
        }

    }


}
