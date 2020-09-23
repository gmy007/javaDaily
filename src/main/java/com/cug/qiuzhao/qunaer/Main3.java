package com.cug.qiuzhao.qunaer;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        String[] poke = new String[m];
        for (int i = 0; i < m; i++) {
            poke[i] = sc.next();
        }
        int[] arr = toArray(poke);
        int fourCount = FourCount(arr);
        int[] Counts = ThreeAndTwoCount(arr);
        if(isHuangjia(poke,arr))
            System.out.println("HuangJiaTongHuaShun");
        else if(isTonghuashun(poke,arr))
            System.out.println("TongHuaShun");
        else if(fourCount>=1)
            System.out.println("SiTiao");
        else if(Counts[0]>=1 && Counts[1]>=1)
            System.out.println("HuLu");
        else if(isTongHua(poke))
            System.out.println("TongHua");
        else if(isShunzi(arr))
            System.out.println("ShunZi");
        else if(Counts[0]>=1)
            System.out.println("SanTiao");
        else if(Counts[1]>=2)
            System.out.println("LiangDui");
        else if(Counts[1] ==1)
            System.out.println("YiDui");
        else
            System.out.println("GaoPai");
    }

    static int[] toArray(String[] poke){
        int n = poke.length;
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            String cur = poke[i].substring(1,poke[i].length());
            if(cur.equals("A"))
                ret[i]=1;
            else if(cur.equals("K"))
                ret[i]=13;
            else if(cur.equals("Q"))
                ret[i]=12;
            else if(cur.equals("J"))
                ret[i]=11;
            else
                ret[i]= Integer.parseInt(cur);
        }
        return ret;
    }
    static boolean isTongHua(String[] poke){
        int n = poke.length;
        HashMap<String, Integer> maps = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String cur = poke[i].substring(0,1);
            maps.put(cur,maps.getOrDefault(cur,0)+1);
        }
        Set<String> keySet = maps.keySet();
        for (String key : keySet) {
            if(maps.get(key)>=5)
                return true;
        }
        return false;
    }
    static boolean isShunzi(int[] arr){
        int n = arr.length;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            int pre = arr[i];
            if(n-i<5)
                continue;
            for (int j = i+1; j <i+5 ; j++) {
                if(arr[j]-pre !=1)
                    break;
                pre = arr[j];
                if(j == i+4)
                    flag=true;
            }
        }
        return flag;
    }
    static boolean isHuangjia(String[] poke,int[] arr){
        if(isTongHua(poke) == false || isShunzi(arr) == false)
            return false;
        int n = poke.length;
        HashMap<String, ArrayList<Integer>> maps = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String cur = poke[i].substring(0,1);
            if(!maps.containsKey(cur)){
            ArrayList<Integer> temp = new ArrayList<>();
            maps.put(cur,maps.getOrDefault(cur,temp));
            temp.add(arr[i]);
            }else
                maps.get(cur).add(arr[i]);
        }
        Set<String> keySet = maps.keySet();
        for (String key : keySet) {
            ArrayList<Integer> lists = maps.get(key);
            if(lists.size()<5)
                continue;
            if(lists.contains(1) &&lists.contains(10)&&lists.contains(11)&&lists.contains(12)&&lists.contains(13))
                return true;
        }
        return false;

    }
    static boolean isTonghuashun(String[] poke,int[] arr){
        if(isTongHua(poke) == false || isShunzi(arr) == false)
            return false;
        int n = poke.length;
        HashMap<String, ArrayList<Integer>> maps = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String cur = poke[i].substring(0,1);
            if(!maps.containsKey(cur)){
                ArrayList<Integer> temp = new ArrayList<>();
                maps.put(cur,maps.getOrDefault(cur,temp));
                temp.add(arr[i]);
            }else
                maps.get(cur).add(arr[i]);
        }
        Set<String> keySet = maps.keySet();
        for (String key : keySet) {
            ArrayList<Integer> lists = maps.get(key);
            if(lists.size()<5)
                continue;
            Integer[] integers = lists.toArray(new Integer[0]);
            Arrays.sort(integers);
            for (int i = 1; i < integers.length; i++) {
                for (int j = i; j < i+5; j++) {
                    if(arr[j]-arr[j-1]!=1)
                        break;
                    if(j == i+4)
                        return true;
                }
            }
        }
        return false;
    }
    static HashMap<Integer,Integer> getCount(int[] arr){
        int n = arr.length;
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < n; i++) {
            maps.put(arr[i],maps.getOrDefault(arr[i],0)+1);

        }
        return maps;
    }
    static int FourCount(int[] arr){
        HashMap<Integer, Integer> maps = getCount(arr);
        Set<Integer> keySet = maps.keySet();
        int count =0;
        for (Integer key : keySet) {
            if(maps.get(key)>=4)
                count++;
        }
        return count;

    }
    static int[] ThreeAndTwoCount(int[] arr){
        HashMap<Integer, Integer> maps = getCount(arr);
        Set<Integer> keySet = maps.keySet();
        int three =0;
        int two =0;
        for (Integer key : keySet) {
            if(maps.get(key)==3)
                three++;
            if(maps.get(key)==2)
                two++;
        }
        return new int[]{three,two};
    }
}
