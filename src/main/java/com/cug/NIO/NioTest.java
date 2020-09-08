package com.cug.NIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NioTest {

    /*
    byteBuffer.put ====== channel.read(byteBuffer)获取
    byteBuffer.get ====== channel.write(byteBuffer)消耗
     */
    public static void main(String[] args) {
        try {
            sampleCopyFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static  void sampleCopyFile() throws IOException{
        FileChannel inChannel = FileChannel.open(Paths.get("cug.zip"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("cugCopy.zip"),StandardOpenOption.CREATE_NEW,StandardOpenOption.WRITE);
        inChannel.transferTo(0,inChannel.size(),outChannel);
        //inChannel.transferFrom(inChannel,0,inChannel.size()); //备选方法2

        inChannel.close();
        outChannel.close();
    }
    public static void copyFile(){


        try(FileChannel inChannel = FileChannel.open(Paths.get("cug.zip"), StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("cugCopy.zip"),StandardOpenOption.CREATE_NEW,StandardOpenOption.WRITE);
        )

        {
            ByteBuffer buffer=ByteBuffer.allocateDirect(1024);
            while(inChannel.read(buffer)!=-1){
                buffer.flip();//切换读/写模式
                outChannel.write(buffer);
                buffer.clear();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
