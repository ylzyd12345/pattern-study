package com.kevin.demo.structural.adapter;

/**
 * ThinkPad电源适配器类 - 适配器模式中的适配器角色(Adapter)
 * 实现目标接口，并持有被适配者的引用，将被适配者的接口转换为目标接口
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class ThinkPadPower implements ComputerPower {
    
    private CommonPower commonPower;

    public ThinkPadPower(CommonPower commonPower) {
        this.commonPower = commonPower;
    }

    @Override
    public int getPower() {
        // 将220V普通电源转换为电脑所需的电压
        return (commonPower.getPower() / Integer.valueOf(100));
    }
}
