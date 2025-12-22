package com.kevin.demo.structural.decorator;

/**
 * 电话抽象类 - 装饰模式中的抽象构件角色(Component)
 * 定义了电话通话的基本接口
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public abstract class Call {

    /**
     * 拨打电话
     * 
     * @param number 电话号码
     */
    protected abstract void call(String number);

}
