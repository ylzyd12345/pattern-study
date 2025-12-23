package com.kevin.demo.creational.factory.simpleFactory;

/**
 * 宝马汽车类 - 简单工厂模式中的具体产品角色(Concrete Product)
 * <p>
 * 该类实现了Car接口，代表宝马品牌汽车的具体实现
 * 在简单工厂模式中，这是工厂可以创建的一种具体产品类型
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class BMWCar implements Car {

    /**
     * 实现汽车行驶功能
     * 输出宝马汽车的行驶信息
     */
    @Override
    public void run() {
        System.out.println("BMW running!");
    }
}
