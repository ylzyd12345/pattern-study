package com.kevin.demo.structral.享元;

public class CircleShape implements Shape {

	private String color;

	@Override
	public void drow() {
		System.out.println("drow a" + color + " circle");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	

}
