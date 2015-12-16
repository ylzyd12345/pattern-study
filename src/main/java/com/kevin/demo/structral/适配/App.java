package com.kevin.demo.structral.适配;

public class App {
	public static void main(String[] args) {
		CommonPower commonPower = new CommonPower();
		ComputerPower computerPower = new ThinkPadPower(commonPower) ;
		System.out.println(computerPower.getPower());
		
	}
}
