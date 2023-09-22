package com.Master.SpringFramework.game;

public class GameRunner {

	private GamingConsole game;
	
	public GameRunner(GamingConsole game) {
		this.game=game;
	}
	
	public void run() {
		
		System.out.println("Running game : " +game);
		
		game.down();
		game.up();
		game.left();
		game.right();
	}
}
