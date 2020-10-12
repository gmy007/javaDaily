package com.cug.leetcode;


import java.util.HashMap;
import java.util.Map;

public class Demo8 {
    public int myAtoi(String str) {
        str = str.trim();
        return 0;
    }

}
class Automation{
    int sign = 1;
    long ret = 0;
    String state = "start";
    static Map<String, String[]> table = new HashMap<String, String[]>(){
        {   // "" +- 123 except
            put("start",new String[]{"start","signed","number","end"});
            put("signed",new String[]{"end","end","number","end"});
            put("number",new String[]{"end","end","number","end"});
            put("end",new String[]{"end","end","end","end"});
        }
    };
    public void get(char c){

    }
    public int get_col(char c){
        if(c==' ')
            return 0;
        if(c=='+'||c=='-')
            return 1;
        if(c>='0' && c<='9')
            return 2;
        return 3;
    }
}
