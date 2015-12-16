package com.kevin.demo.creational.工and抽.抽象工厂;

public class HaierTVFactory implements HaierFactory {

	@Override
	public HaierTV createTV() {
		return new HaierTV() {
			
			@Override
			public void play() {
				System.out.println("haier TV play!");
			}
		};
	}

	@Override
	public HaierWasher createWasher() {
		// TODO Auto-generated method stub
		return null;
	}

}
