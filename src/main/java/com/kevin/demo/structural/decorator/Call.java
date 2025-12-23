package com.kevin.demo.structural.decorator;

/**
 * 电话抽象类 - 装饰器模式中的组件角色(Component)
 * <p>
 * 装饰器模式(Decorator Pattern)：动态地给一个对象添加一些额外的职责
 * 就增加功能来说，装饰器模式相比生成子类更为灵活
 * <p>
 * 该类定义了电话的基本接口，所有具体电话类和装饰器类都实现此接口
 * 作为装饰器模式的基础，定义了可以被装饰的核心操作
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public abstract class Call {
    
    /**
     * 拨打电话的抽象方法
     * 定义了电话系统的核心功能，具体实现由子类提供
     * 
     * @param number 要拨打的电话号码
     */
    protected abstract void call(String number);
}
