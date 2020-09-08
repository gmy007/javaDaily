package com.cug.NIO;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class TestNonBlockingNIO {

    @Test
    public void client() throws  IOException{
         SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

         socketChannel.configureBlocking(false);

         ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

         Scanner sc=new Scanner(System.in);
         while(sc.hasNext()){
            String s = sc.next();
            byteBuffer.put((new Date().toString()+"\n"+s).getBytes());
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();

        }
//        byteBuffer.put("HelloWorld".getBytes());
//        byteBuffer.flip();
//        socketChannel.write(byteBuffer);

        socketChannel.close();

    }


    @Test
    public void server() throws IOException {
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //切换非阻塞式IO
        ssChannel.configureBlocking(false);
        //绑定链接
        ssChannel.bind(new InetSocketAddress(9898));
        //新建选择器
         Selector selector = Selector.open();
        //将通道注册到选择器上，并且指定“监听接收事件”
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        //轮询式的获取选择器上已经“准备就绪”的事件
        while(selector.select()>0){
            //获取当前选择器中所有注册的选择键(已注册的监听事件)
             Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while(iterator.hasNext()){
                //获取就绪事件
                 SelectionKey selectionKey = iterator.next();
                 //判断是什么事件类型准备就绪
                if(selectionKey.isAcceptable()){
                    //若就绪，获取客户连接
                    SocketChannel sChannel = ssChannel.accept();
                    //切换非阻塞
                    sChannel.configureBlocking(false);
                    //可读的管道!!!!!注册到选择器
                    sChannel.register(selector,SelectionKey.OP_READ);

                }else  if(selectionKey.isReadable()){
                    //判断管道可读以后，强转，再开始读取
                    SocketChannel sChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int len=0;
                    while((len=sChannel.read(byteBuffer))!=-1){
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(),0,len));
                        byteBuffer.clear();
                    }

                }
                iterator.remove();//删掉当前的事件
            }
        }
    }
}
