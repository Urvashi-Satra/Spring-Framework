package com.Master.SpringFramework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GamingConsole {

	@Override
	public void up() {
		// TODO Auto-generated method stub
		System.out.println("Up");
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		System.out.println("sit down");
	}

	@Override
	public void left() {
		// TODO Auto-generated method stub
		System.out.println("Go back");
	}

	@Override
	public void right() {
		// TODO Auto-generated method stub
		System.out.println("Shoot a bullet");
	}

}
