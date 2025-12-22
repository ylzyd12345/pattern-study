package com.kevin.demo.structral.adapter;

/**
 * ThinkPad电源适配器类 - 适配器模式中的适配器角色(Adapter)
 * 实现目标接口，并持有被适配者的引用，将被适配者的接口转换为目标接口
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class ThinkPadPower implements ComputerPower {
    
    /**
     * 普通电源引用 - 被适配者对象
     */
    private CommonPower commonPower;

    /**
     * 构造函数
     * @param commonPower 普通电源对象
     */
    public ThinkPadPower(CommonPower commonPower) {
        this.commonPower = commonPower;
    }

    @Override
    public int getPower() {
        // 将220V普通电源转换为电脑所需的电压
        return (commonPower.getPower() / Integer.valueOf(100));
    }
}