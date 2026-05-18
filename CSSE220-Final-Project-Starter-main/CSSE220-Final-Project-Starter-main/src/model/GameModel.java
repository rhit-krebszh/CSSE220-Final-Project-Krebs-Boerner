package model;

import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
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
	private int[][] maze;
	public static final int TILE_SIZE = 40;
	
	private int lives = 3;
	private int score = 0;
	private boolean gameOver = false;
	private ArrayList<Item> items = new ArrayList<>();
	
	public GameModel() {
		loadLevel("/model/level1");
		player = new Player(5,5);	
		enemy = new Enemy(3,3);
		
		Timer timer = new Timer(30, e -> update());
		timer.start();
	}
	public void loadLevel(String filename) {

	    int row = 0;

	    InputStream stream =
	        GameModel.class.getResourceAsStream(filename);

	    if (stream == null) {
	        throw new IllegalStateException(
	            "Level file not found: " + filename
	        );
	    }

	    Scanner scanner = new Scanner(stream);

	    ArrayList<String> lines = new ArrayList<>();

	    // read all lines first
	    while (scanner.hasNextLine()) {
	        lines.add(scanner.nextLine());
	    }

	    scanner.close();

	    int rows = lines.size();
	    int cols = lines.get(0).length();

	    maze = new int[rows][cols];

	    for (row = 0; row < rows; row++) {

	        String line = lines.get(row);

	        for (int col = 0; col < cols; col++) {

	            char ch = line.charAt(col);

	            // WALL
	            if (ch == '#') {
	                maze[row][col] = 1;
	            }

	            // EMPTY SPACE
	            else if (ch == '.') {
	                maze[row][col] = 0;
	            }

	            // PLAYER
	            else if (ch == 'P') {

	                maze[row][col] = 0;

	                player = new Player(row, col);
	            }

	            // ENEMY
	            else if (ch == 'E') {

	                maze[row][col] = 0;

	                enemy = new Enemy(row, col);
	            }
	                
	            else if (ch == 'C') {
	            	items.add(new Item(row, col));
	                
	            }
	        }
	    }
	}
	
public boolean isWall(int row, int col) {
	if (row < 0 || col < 0 ||
			row >= maze.length ||
	        col >= maze[0].length) {
	        return true;
	    }
	return maze[row][col] == 1;
	}
public void checkEnemyCollision() {
	if (gameOver) return;
	
	if (player.getRow() == enemy.getRow() && player.getCol() == enemy.getCol()) {
		lives--;
		//player.reset();
		if (lives <= 0) {
			gameOver = true;
		}
	}
}

public void checkItemCollection() {
	for (Item item : items) {
		if (!item.isCollected() && player.getRow() == item.getRow() && player.getCol() == item.getCol()) {
			item.collect();
			score++;
		}
	}
}

public Player getPlayer() {
	return player;
}
public Enemy getEnemy() {
	return enemy;
}
public int[][] getMaze() {
    return maze;
}

public void update() {
	if (gameOver) return;
	enemy.update(this);
	checkEnemyCollision();
	checkItemCollection();
}
public ArrayList<Item> getItems() {
    return items;
}

public int getLives() {
	return lives;
}
public int getScore() {
	return score;
}
public boolean isGameOver() {
	return gameOver;
}
	
	// Work on the lab to complete GameModel and Player for initial setup

}
