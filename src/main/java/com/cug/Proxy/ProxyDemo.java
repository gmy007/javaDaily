package com.cug.Proxy;

import java.lang.reflect.Proxy;

public class ProxyDemo  {
    public static void main(String[] args) {
        SaleComputer saleComputer = new SaleComputer();
        Computer proxyInstance = (Computer)Proxy.newProxyInstance(saleComputer.getClass().getClassLoader(),//类加载器
                saleComputer.getClass().getInterfaces(),//代理对象的接口
                ((proxy, method, args1) -> {//实例方法
                    if (method.getName().equals("sale")) {
                        System.out.println("送你一个鼠标垫");
                        return method.invoke(saleComputer, args1);
                    }
                    if (method.getName().equals("show")) {
                        for (String s : SaleComputer.COMPUTERS) {
                            System.out.println("我有一台价值" + s + "的电脑。。。。。");
                        }
                        method.invoke(saleComputer, args1);
                        return "".equals(SaleComputer.COMPUTERS.get(0)) ? "没有电脑" : SaleComputer.COMPUTERS.get(0);
                    }
                    return null;
                }));
        proxyInstance.sale("8000");
        System.out.println(proxyInstance.show());
    }
}
