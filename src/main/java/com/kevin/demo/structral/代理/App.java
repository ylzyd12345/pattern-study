package com.kevin.demo.structral.代理;

/**
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		PlayGame playGame = new PlayGameProxy(new BabyPlayGame());
		playGame.play("小蝌蚪找妈妈");
		playGame.play("yellowGame");
		
	}
}
