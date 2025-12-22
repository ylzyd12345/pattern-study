package com.kevin.demo.structural.decorator;

/**
 * 记录装饰器类 - 装饰模式中的具体装饰角色(ConcreteDecorator)
 * 为电话添加通话记录功能
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class RecordDecorator extends CallDecorator {

    public RecordDecorator(Call call) {
        super(call);
    }

    @Override
    protected void call(String number) {
        long begintime = System.currentTimeMillis();
        super.call(number);
        long endtime = System.currentTimeMillis();
        record(begintime, endtime, number);
    }

    private void record(long begintime, long endtime, String number) {
        System.out.println("通话记录: 拨打" + number + ", 通话时长: " + (endtime - begintime) + "毫秒");
    }

}
