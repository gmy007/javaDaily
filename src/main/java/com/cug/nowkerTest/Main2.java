package com.cug.nowkerTest;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n*3;i++){
            list.add(scanner.nextInt());
        }
        Collections.sort(list);
        long ret=0;
        for (int i = 0; i <n ; i++) {
            ret+=list.get(3*n-2*(i+1));
        }
        System.out.println(ret);
    }
}
