package com.Master.SpringFramework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.Master.SpringFramework.game.GameRunner;
import com.Master.SpringFramework.game.GamingConsole;
import com.Master.SpringFramework.game.PacmanGame;




@Configuration
@ComponentScan("com.Master.SpringFramework.game")
public class GamingAppLauncherApplication {
	
	//Step1 
//	@Bean
//	public GamingConsole game() {
//		var game = new PacmanGame();
//		return game;
//	}
//	
//	@Bean
//	public GameRunner gameRunner(GamingConsole game) {
//		var gameRunner = new GameRunner(game);
//		return gameRunner;
//	}
	
	//
	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {
			context.getBean(GamingConsole.class).up();
			
			context.getBean(GameRunner.class).run();
		}

	}
}
