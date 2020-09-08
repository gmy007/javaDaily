package com.cug.designModel.decoratorPattern;

public class MilkTea extends BeverageDecorator {

    public MilkTea(Beverage beverage){
        this.beverage=beverage;
    }
    @Override
    public void drink() {
        beverage.drink();
        System.out.println("同时喝了一杯茶。。。变成了奶茶。。。");
    }

    @Override
    public void cost() {
        beverage.cost();
        System.out.println("再付3元茶钱。。。");
    }

    public static void main(String[] args) {
        Milk beverage = new Milk();
        MilkTea milkTea = new MilkTea(beverage);
        milkTea.drink();
    }
}
