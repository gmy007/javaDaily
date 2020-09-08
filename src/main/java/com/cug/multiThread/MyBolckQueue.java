package com.cug.multiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBolckQueue<T> {
    Object[] items ;
    volatile  int addIndex,rmIndex,count;
    static Lock lock=new ReentrantLock();
    Condition notFull=lock.newCondition();
    Condition notEmpty=lock.newCondition();

    public MyBolckQueue(int size){
        this.items=new Object[size];
        addIndex=0;
        rmIndex=0;
        count=0;
    }

    public void add(T t){
        lock.lock();
        try{
            while(count>=items.length)
                notFull.await();
            count++;
            items[addIndex++]=t;
            if(addIndex==items.length)
                addIndex=0;
            notEmpty.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public T remove(){
        lock.lock();
        try{
            while(count==0)
                notEmpty.await();
            count--;
            Object x=items[rmIndex++];
            if(rmIndex==items.length)
                rmIndex=0;
            notFull.signal();
            return (T)x;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return  null;
    }
}
