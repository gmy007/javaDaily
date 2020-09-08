package com.cug.demo0313;

import jdk.nashorn.internal.ir.CallNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class demo1 {
    public static void main(String[] args) {
        String[] aabs = new demo1().permutation("aab");
    }
    public String[] permutation(String s) {
        List<String> ans = new ArrayList<>();
        char[] arrayS = s.toCharArray();
        Arrays.sort(arrayS);
        permutationHelper(ans, new boolean[s.length()], new LinkedList<Character>(), arrayS);
        String[] res = new String[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }
    private void permutationHelper(List<String> ans, boolean[] visited, LinkedList<Character> list, char[] s){
        if(list.size() == s.length){
            StringBuilder sb = new StringBuilder();
            for(char c : list){
                sb.append(c);
            }
            ans.add(sb.toString());
            return;
        }

        for(int i = 0; i < s.length; i++){
            if(i != 0 && s[i] == s[i - 1] && visited[i - 1]) continue;
            if(!visited[i]){
                list.addLast(s[i]);
                visited[i] = true;
                permutationHelper(ans, visited, list, s);
                list.removeLast();
                visited[i] = false;
            }
        }
    }
}

