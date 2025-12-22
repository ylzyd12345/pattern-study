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

    /**
     * 被装饰的电话对象
     */
    private Call call;

    /**
     * 构造方法
     * 
     * @param call 要装饰的电话对象
     */
    public CallDecorator(Call call) {
        this.call = call;
    }

    /**
     * 拨打电话
     * 
     * @param number 电话号码
     */
    @Override
    protected void call(String number) {
        call.call(number);
    }

}
