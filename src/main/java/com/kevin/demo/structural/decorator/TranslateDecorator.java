package com.kevin.demo.structural.decorator;

/**
 * 翻译装饰器类 - 装饰模式中的具体装饰角色(ConcreteDecorator)
 * 为电话添加翻译功能
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class TranslateDecorator extends CallDecorator {

    /**
     * 构造方法
     * 
     * @param call 要装饰的电话对象
     */
    public TranslateDecorator(Call call) {
        super(call);
    }

    /**
     * 拨打电话并提供翻译服务
     * 
     * @param number 电话号码
     */
    @Override
    protected void call(String number) {
        super.call(number);
        translate(number);
    }

    /**
     * 提供翻译服务
     * 
     * @param number 电话号码
     */
    private void translate(String number) {
        System.out.println("翻译服务: 为拨打" + number + "的通话提供实时翻译");
    }

}
