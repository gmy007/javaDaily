package com.cug.designModel.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherSubject implements  Subject {
    private List<Observer> observers;
    private int state;
    public WeatherSubject(){
        this.observers=new ArrayList<>();
    }
    public void setState(int newState){
        this.state=newState;
        notifyObserver();//通知所有观察者
    }
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers) {
            o.update(state);

        }
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(!observers.isEmpty())
            observers.remove(i);
    }

    public static void main(String[] args) {
        WeatherSubject weatherSubject = new WeatherSubject();
        BinaryObserver binaryObserver = new BinaryObserver(weatherSubject);
        HexObserver hexObserver=new HexObserver(weatherSubject);
        weatherSubject.setState(15);
        System.out.println();
        weatherSubject.setState(25);
    }
}
