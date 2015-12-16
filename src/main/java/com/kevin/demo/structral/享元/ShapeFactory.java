package com.kevin.demo.structral.享元;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
	private static Map<String, Shape> shapeMap = new HashMap<>();

	public static Shape getShape(String color) {

		if (null == shapeMap.get(color)) {
			CircleShape circleShape = new CircleShape();
			circleShape.setColor(color);
			shapeMap.put(color, circleShape);
		}

		return shapeMap.get(color);
	}

}
