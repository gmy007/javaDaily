package com.cug.Proxy;

import java.util.ArrayList;

public class SaleComputer implements Computer {
    public static ArrayList<String> COMPUTERS;

    static {
        COMPUTERS=new ArrayList();
    }
    public SaleComputer(){};
    @Override
    public void sale(String price) {
        System.out.println("在北京专卖店买了一个一台"+price+"的电脑。。。。。");
        COMPUTERS.add(price);
    }

    @Override
    public String show() {
        return null;
    }
}
