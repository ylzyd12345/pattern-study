package com.kevin.demo.structral.享元;

public class App {
	public static void main(String[] args) {
		Shape redCircle = ShapeFactory.getShape("red")	;
		redCircle.drow();
		
		redCircle = ShapeFactory.getShape("yellow");
		redCircle.drow();
	}
}
