package com.cug.designModel.ObserverPattern;

public class BinaryObserver implements Observer {

    public BinaryObserver(Subject s){
        s.registerObserver(this);
    }
    @Override
    public void update(int a) {
        System.out.println("Binary temperature is   "+Integer.toBinaryString(a));
    }
}
