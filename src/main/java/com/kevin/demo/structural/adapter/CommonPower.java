package com.kevin.demo.structural.adapter;

/**
 * 普通电源类 - 适配器模式中的被适配者角色(Adaptee)
 * 定义一个已存在的接口，这个接口需要被适配
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class CommonPower {
    public int getPower() {
        return 220;
    }
}
