package com.kevin.demo.creational.抽象factory;

/**
 * App类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class App {
	public static void main(String[] args) {
		HaierFactory haierFactory = new HaierTVFactory();
		haierFactory.createTV().play();
		
		haierFactory = new HaierWasherFactory();
		haierFactory.createWasher().run();
		
	}
}
