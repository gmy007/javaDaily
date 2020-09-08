package com.cug.designModel.ObserverPattern;

public interface Subject {
    //设置主题 被观察的类
    void registerObserver(Observer o);
    void notifyObserver();
    void removeObserver(Observer o);
}
