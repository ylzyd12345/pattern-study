package com.kevin.demo.structral.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 形状工厂类 - 享元模式中的享元工厂角色(FlyweightFactory)
 * 负责创建和管理享元对象，确保享元对象的合理共享
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class ShapeFactory {
    
    /**
     * 形状缓存池 - 存储已创建的享元对象
     */
    private static Map<String, Shape> shapeMap = new HashMap<>();

    /**
     * 获取形状对象
     * 如果缓存中存在指定颜色的形状，则直接返回；否则创建新的形状对象并放入缓存
     * 
     * @param color 形状颜色（内部状态）
     * @return Shape 形状对象
     */
    public static Shape getShape(String color) {
        if (null == shapeMap.get(color)) {
            CircleShape circleShape = new CircleShape();
            circleShape.setColor(color);
            shapeMap.put(color, circleShape);
            System.out.println("Creating a new " + color + " circle");
        } else {
            System.out.println("Reusing existing " + color + " circle");
        }
        return shapeMap.get(color);
    }
}