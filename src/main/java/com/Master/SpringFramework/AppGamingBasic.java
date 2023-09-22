package com.Master.SpringFramework;

import com.Master.SpringFramework.game.GameRunner;
import com.Master.SpringFramework.game.MarioGame;
import com.Master.SpringFramework.game.PacmanGame;
import com.Master.SpringFramework.game.SuperContraGame;

public class AppGamingBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//			var game=new MarioGame();
//		var game = new SuperContraGame();
		var game = new PacmanGame();
		var gameRunner = new GameRunner(game);
		gameRunner.run();
		
	}

}
