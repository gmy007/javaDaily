package com.cug.leetcode;

import javafx.util.Pair;

import java.util.*;
public class Demo127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,List<String>> maps = new HashMap<>();
        int n = beginWord.length();
        wordList.forEach(word->{
            for(int i=0;i<n;i++){
                String newWord = word.substring(0,i)+"*"+word.substring(i+1,n);
                List<String> cur = maps.getOrDefault(newWord,new ArrayList<>());
                cur.add(word);
                maps.put(newWord,cur);
            }
        });
        Queue<Pair<String,Integer>> queue = new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        Map<String,Boolean> visited = new HashMap<>();
        visited.put(beginWord,true);
        while(!queue.isEmpty()){
            Pair<String,Integer> cur = queue.remove();
            String word = cur.getKey();
            int level = cur.getValue();
            for(int i=0;i<n;i++){
                String newWord = word.substring(0,i)+"*"+word.substring(i+1,n);
                for(String s : maps.getOrDefault(newWord,new ArrayList<>())){
                    if(s.equals(endWord))
                        return level+1;
                    if(!visited.containsKey(s)){
                        visited.put(s,true);
                        queue.add(new Pair(s,level+1));
                    }
                }
            }
        }
        return 0;
    }
}
