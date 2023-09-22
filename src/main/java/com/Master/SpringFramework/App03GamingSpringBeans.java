package com.Master.SpringFramework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Master.SpringFramework.game.GameRunner;
import com.Master.SpringFramework.game.GamingConsole;

public class App03GamingSpringBeans {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
			context.getBean(GamingConsole.class).up();
			
			context.getBean(GameRunner.class).run();
		}

	}
}
