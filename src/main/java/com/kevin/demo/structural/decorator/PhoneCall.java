package com.kevin.demo.structural.decorator;

/**
 * 电话类 - 装饰模式中的具体构件角色(ConcreteComponent)
 * 实现了电话通话的基本功能
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class PhoneCall extends Call {

    /**
     * 拨打电话
     * 
     * @param number 电话号码
     */
    @Override
    protected void call(String number) {
        System.out.println("拨打电话，号码是: " + number);
    }

}
