package com.cug.IO;

import java.io.*;

public class ObjectOutput {
    public static void main(String[] args) {
        File file = new File("serializable.txt");
        //outputStream = null;
        try (FileOutputStream outputStream = new FileOutputStream("serializable.txt");
             ObjectOutputStream stream = new ObjectOutputStream(outputStream);){


            stream.writeObject(new Person("na",12));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
