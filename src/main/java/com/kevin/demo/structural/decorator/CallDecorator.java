package com.kevin.demo.structural.decorator;

/**
 * 电话装饰器抽象类 - 装饰模式中的抽象装饰角色(Decorator)
 * 实现了电话接口，并持有一个电话对象的引用
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class CallDecorator extends Call {

    private Call call;

    public CallDecorator(Call call) {
        this.call = call;
    }

    @Override
    protected void call(String number) {
        call.call(number);
    }

}
