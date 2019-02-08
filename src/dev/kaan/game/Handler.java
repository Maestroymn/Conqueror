package dev.kaan.game;

import dev.kaan.game.input.MouseManager;


public class Handler {

	private Game game;
	
	
	public Handler(Game game) {
		this.game=game;	
	}

	public int getWidth() {
		return game.width;
	}
	
	public int getHeight() {
		return game.height;
	}
	
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
