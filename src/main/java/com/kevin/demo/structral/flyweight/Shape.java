package com.kevin.demo.structral.flyweight;

/**
 * 形状接口 - 享元模式中的抽象享元角色(Flyweight)
 * 定义享元对象的公共接口，包含非共享的外部状态参数
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public interface Shape {
    /**
     * 绘制形状
     */
    void drow();
}