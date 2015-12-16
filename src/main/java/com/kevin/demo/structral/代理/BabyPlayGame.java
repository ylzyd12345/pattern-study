package com.kevin.demo.structral.代理;

public class BabyPlayGame implements PlayGame {

	@Override
	public void play(String gameName) {
		System.out.println("ok, u can play game:" + gameName);
	}
	
}
