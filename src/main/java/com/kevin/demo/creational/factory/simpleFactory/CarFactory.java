package com.kevin.demo.creational.factory.simpleFactory;

/**
 * 汽车工厂类 - 简单工厂模式中的工厂角色(Factory)
 * <p>
 * 简单工厂模式(Simple Factory Pattern)：定义一个工厂类，它可以根据参数的不同创建不同类的实例
 * 被创建的实例通常都具有共同的父类。简单工厂模式不属于23种经典设计模式，但它是工厂方法模式的特殊实现。
 * <p>
 * 该类负责根据汽车类型创建具体的汽车实例，客户端无需知道具体的创建逻辑
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class CarFactory {
    
    /**
     * 根据汽车类型创建对应的汽车实例
     * 
     * @param carType 汽车类型枚举，指定要创建的汽车类型
     * @return 对应类型的汽车实例，如果类型不支持则返回null
     */
    public static Car createCar(CarTypeEnum carType) {
        if (CarTypeEnum.BMW == carType) {
            return new BMWCar();
        } else if (CarTypeEnum.BENZ == carType) {
            return new BENZCar();
        } else {
            return null;
        }
    }
}
