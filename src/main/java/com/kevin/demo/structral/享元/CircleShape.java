package com.kevin.demo.structral.享元;

/**
 * 圆形实现类 - 享元模式中的具体享元角色(ConcreteFlyweight)
 * 实现抽象享元接口，包含内部状态(color)和外部状态
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class CircleShape implements Shape {
    
    /**
     * 颜色 - 享元对象的内部状态，可共享
     */
    private String color;

    @Override
    public void drow() {
        System.out.println("drow a " + color + " circle");
    }

    /**
     * 获取颜色
     * @return 颜色字符串
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置颜色
     * @param color 颜色字符串
     */
    public void setColor(String color) {
        this.color = color;
    }
}