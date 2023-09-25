package com.Master.SpringFramework.game;

import org.springframework.stereotype.Component;

@Component
public class PacmanGame implements GamingConsole {

	@Override
	public void up() {
		// TODO Auto-generated method stub

		System.out.println("Up");
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub

		System.out.println("down");
	}

	@Override
	public void left() {
		// TODO Auto-generated method stub

		System.out.println("left");
	}

	@Override
	public void right() {
		// TODO Auto-generated method stub

		System.out.println("right");
	}

}
