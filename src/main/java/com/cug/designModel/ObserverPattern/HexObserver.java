package com.cug.designModel.ObserverPattern;

public class HexObserver implements Observer {

    public HexObserver(Subject s){
        s.registerObserver(this);
    }
    @Override
    public void update(int a) {
        System.out.println("Hex temperature is   "+Integer.toHexString(a));
    }
}
