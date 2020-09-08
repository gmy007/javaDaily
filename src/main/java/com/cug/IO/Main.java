package com.cug.IO;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.copyFile(new File("serializable.txt"));
        HashSet<Object> objects = new HashSet<>();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    }

    public void copyFile(File file){

        try(BufferedInputStream fileReader = new BufferedInputStream(new FileInputStream(file));
            BufferedOutputStream fileWriter = new BufferedOutputStream(new FileOutputStream("newText.txt"));){
            byte[] bytes = new byte[1024*10];
            int len =0;
            while( (len =fileReader.read(bytes))!=-1){
                fileWriter.write(bytes,0,len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
