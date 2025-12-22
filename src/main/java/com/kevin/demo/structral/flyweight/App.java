package com.kevin.demo.structral.flyweight;

/**
 * 享元模式演示类
 * 用于展示如何使用享元模式创建和管理共享的形状对象
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class App {
    public static void main(String[] args) {
        // 获取红色圆形（创建新对象）
        Shape redCircle = ShapeFactory.getShape("red");
        redCircle.drow();
        
        // 再次获取红色圆形（复用已有的对象）
        redCircle = ShapeFactory.getShape("red");
        redCircle.drow();
        
        // 获取黄色圆形（创建新对象）
        Shape yellowCircle = ShapeFactory.getShape("yellow");
        yellowCircle.drow();
    }
}