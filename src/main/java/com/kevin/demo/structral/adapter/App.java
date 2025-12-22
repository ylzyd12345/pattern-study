package com.kevin.demo.structral.adapter;

/**
 * 适配器模式演示类
 * 用于展示如何使用适配器模式将普通电源转换为电脑所需的电源
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class App {
    public static void main(String[] args) {
        // 创建普通电源对象（220V）
        CommonPower commonPower = new CommonPower();
        
        // 使用适配器将普通电源转换为电脑所需的电源
        ComputerPower computerPower = new ThinkPadPower(commonPower);
        
        // 输出电脑获得的电压
        System.out.println("电脑获得的电压：" + computerPower.getPower() + "V");
    }
}