package com.Master.SpringFramework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Master.SpringFramework.game.GameRunner;
import com.Master.SpringFramework.game.GamingConsole;
import com.Master.SpringFramework.game.PacmanGame;

@Configuration
public class GamingConfiguration {

	@Bean
	public GamingConsole game() {
		var game = new PacmanGame();
		return game;
	}
	
	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		var gameRunner = new GameRunner(game);
		return gameRunner;
	}
}
