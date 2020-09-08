package com.cug.jdk8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.Stream;

public class MainStream {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        Stream<String> listStream = strings.stream();
        strings.add("123");
        strings.add("456");
        strings.add("789");
        listStream.forEach(name-> System.out.println(name));
        strings.stream().map(name->Integer.parseInt(name)).forEach(name-> System.out.println(name));
        LockSupport.park();
    }
}
