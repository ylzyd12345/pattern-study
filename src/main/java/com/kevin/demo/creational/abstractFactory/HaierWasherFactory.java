package com.kevin.demo.creational.抽象factory;

/**
 * HaierWasherFactory类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class HaierWasherFactory implements HaierFactory {

	@Override
	public HaierTV createTV() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HaierWasher createWasher() {
		return new HaierWasher() {
			
			@Override
			public void run() {
				System.out.println("haier wahser run!");
			}
		};
	}

}
