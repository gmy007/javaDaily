package com.cug.NIO;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestBlockingNIO {
    @Test
    public void client() throws IOException {
        SocketChannel client = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        FileChannel inChannel =FileChannel.open(Paths.get("cug.zip"), StandardOpenOption.READ);
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        while(inChannel.read(byteBuffer)!=-1){
            byteBuffer.flip();
            client.write(byteBuffer);
            byteBuffer.clear();
        }
        inChannel.close();
        client.close();
    }

    @Test
    public void server() throws IOException{
        ServerSocketChannel server = ServerSocketChannel.open();

        server.bind(new InetSocketAddress(9898));
        final SocketChannel accept = server.accept();//阻塞等待连接状态

        FileChannel outChannel =FileChannel.open(Paths.get("cugCopy2.zip"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);

        while(accept.read(byteBuffer)!=-1){
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        outChannel.close();
        accept.close();
        server.close();

    }
}
