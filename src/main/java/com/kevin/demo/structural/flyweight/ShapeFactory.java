package com.kevin.demo.structural.flyweight;

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
    
    private static Map<String, Shape> shapeMap = new HashMap<>();

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
