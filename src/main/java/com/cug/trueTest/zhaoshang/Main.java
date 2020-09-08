package com.cug.trueTest.zhaoshang;


import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String[] s=new String[n];
        for (int i = 0; i < n; i++) {
            s[i]=sc.next();
        }
        HashMap<String, String> maps = new HashMap<>();
        maps.put("1","1");maps.put("5","2");
        maps.put("2","5");maps.put("8","3");
        maps.put("3","8");maps.put("7","4");
        maps.put("4","7");maps.put("9","6");
        maps.put("6","9");
        String[] cs = new String[n];
        boolean b=true;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            cs[i]=sb.append(s[i]).reverse().toString();
            for (int j = 0; j < cs[i].length(); j++) {
                String s1 = String.valueOf(cs[i].charAt(j));
                String s2 = maps.get(String.valueOf(s[i].charAt(j)));
                if(!s1.equals(s2)) {
                    b=false;
                    break;
                }
            }
            if(b)
                System.out.println("YES");
            else
                System.out.println("NO");
            b=true;
        }

    }
}
