package com.cug.designModel.decoratorPattern;

public class Milk implements Beverage {
    @Override
    public void drink() {
        System.out.println("牛奶真好喝。。。。。");
    }

    @Override
    public void cost() {
        System.out.println("一杯牛奶花费3元。。。");
    }
}
