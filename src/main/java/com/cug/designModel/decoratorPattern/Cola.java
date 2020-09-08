package com.cug.designModel.decoratorPattern;

public class Cola implements Beverage {

    @Override
    public void drink() {
        System.out.println("可乐真好喝。。。。");
    }

    @Override
    public void cost() {
        System.out.println("一听可乐花费3元。。。");
    }
}
