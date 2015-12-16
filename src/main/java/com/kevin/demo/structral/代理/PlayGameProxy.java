package com.kevin.demo.structral.代理;

public class PlayGameProxy implements PlayGame {

	private PlayGame playGame;
	
	public PlayGameProxy(PlayGame playGame) {
		this.playGame = playGame;
	}



	@Override
	public void play(String gameName) {
		
		if (playGame instanceof BabyPlayGame) {
			if ("yellowGame".equalsIgnoreCase(gameName)) {
				System.err.println("no no no, u can't play this game!");
				return;
			}
		}
		
		playGame.play(gameName);
	}

}
