package com.kevin.demo.creational.抽象工厂;

public class App {
	public static void main(String[] args) {
		HaierFactory haierFactory = new HaierTVFactory();
		haierFactory.createTV().play();
		
		haierFactory = new HaierWasherFactory();
		haierFactory.createWasher().run();
		
	}
}
