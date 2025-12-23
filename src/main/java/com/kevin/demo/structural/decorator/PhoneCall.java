package com.kevin.demo.structural.decorator;

/**
 * 普通电话类 - 装饰器模式中的具体组件角色(Concrete Component)
 * <p>
 * 该类实现了电话的基本通话功能，是装饰器模式中的核心组件
 * 其他装饰器可以基于此类添加额外功能，如录音、翻译等
 * <p>
 * 作为最基础的电话实现，提供了标准拨号功能
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class PhoneCall extends Call {

    /**
     * 实现基本的电话拨号功能
     * 输出拨打电话的信息，模拟真实的电话拨打过程
     * 
     * @param number 要拨打的电话号码
     */
    @Override
    protected void call(String number) {
        System.out.println("拨打电话，号码是: " + number);
    }
}
