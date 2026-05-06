package model;

import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Stores the current state of the game and controls the main game rules.
 * 
 * This is where the game keeps track of objects such as the player,
 * walls, gems, zombies, score, lives, and levels.
 * 
 * GameModel should update the game state, but it should not draw anything.
 * Drawing belongs in GameComponent.
 */

public class GameModel {
	private Player player;
	private Enemy enemy;
	
	public GameModel() {
		player = new Player(5,5,20);	
		enemy = new Enemy(3,3);
		
		Timer timer = new Timer(30, e -> update());
		timer.start();
	}
		
//		Timer timer = new Timer(30, new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				update();
//			}
//		}};
//		timer.start();
//	}

public Player getPlayer() {
	return player;
}
public Enemy getEnemy() {
	return enemy;
}

public void update() {
	enemy.update();
}
	
	// Work on the lab to complete GameModel and Player for initial setup

}
