package com.kevin.demo.creational.工and抽.抽象工厂;

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
