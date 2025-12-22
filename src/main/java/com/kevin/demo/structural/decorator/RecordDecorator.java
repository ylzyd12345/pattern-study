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

    /**
     * 构造方法
     * 
     * @param call 要装饰的电话对象
     */
    public RecordDecorator(Call call) {
        super(call);
    }

    /**
     * 拨打电话并记录通话时间
     * 
     * @param number 电话号码
     */
    @Override
    protected void call(String number) {
        long begintime = System.currentTimeMillis();
        super.call(number);
        long endtime = System.currentTimeMillis();
        record(begintime, endtime, number);
    }

    /**
     * 记录通话时间
     * 
     * @param begintime 开始时间
     * @param endtime 结束时间
     * @param number 电话号码
     */
    private void record(long begintime, long endtime, String number) {
        System.out.println("通话记录: 拨打" + number + ", 通话时长: " + (endtime - begintime) + "毫秒");
    }

}
