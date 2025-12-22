package com.kevin.demo.structural.flyweight;

/**
 * 圆形实现类 - 享元模式中的具体享元角色(ConcreteFlyweight)
 * 实现抽象享元接口，包含内部状态(color)和外部状态
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class CircleShape implements Shape {
    
    private String color;

    @Override
    public void drow() {
        System.out.println("drow a " + color + " circle");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
