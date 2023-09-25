package com.Master.SpringFramework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

	private GamingConsole game;
	//To run bean of primary annotation i.e
	//mario game we have declared
//	public GameRunner( GamingConsole game) {
//		this.game=game;
//	}
	
	//To run bean with Specific qualifier mentioned
	public GameRunner (
			@Qualifier("SuperContraGameQualifier") 
			GamingConsole game) {
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
