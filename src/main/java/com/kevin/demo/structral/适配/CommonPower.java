package com.kevin.demo.structral.适配;

/**
 * 普通电源类 - 适配器模式中的被适配者角色(Adaptee)
 * 定义一个已存在的接口，这个接口需要被适配
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class CommonPower {
    /**
     * 获取普通电源电压
     * @return int 电源电压（单位：伏）
     */
    public int getPower() {
        return 220;
    }
}