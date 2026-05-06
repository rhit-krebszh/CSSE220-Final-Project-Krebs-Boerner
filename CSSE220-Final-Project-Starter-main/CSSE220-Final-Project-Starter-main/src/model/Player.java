package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

import ui.GameComponent;


public class Player {

	private int x, y, radius;
	private int startX; // we use this for storing initial values
	private int startY; // we use this for storing initial values
	BufferedImage sprite;
	private static final int TILE_SIZE = 40;
	private int col;
	private int row;
	
	private int dx = 5;
	private int dy = 5;
	
	
	public Player(int x, int y, int radius) {
		this.x = x - radius;
		this.y = y - radius;
		this.radius = radius;
		this.startX = x; // the initial position
		this.startY = y; // the initial position
	
	
		try {
			sprite = ImageIO.read(Player.class.getResource("zombie.png"));
		} catch (IOException e) {
			
			sprite = null;
			}
		}
		
		public void drawOn(Graphics2D g2) {
  			int x = this.col * TILE_SIZE;
  			int y = this.row * TILE_SIZE;
  			
  			if (sprite != null) {
  				g2.drawImage(sprite, x, y, TILE_SIZE, TILE_SIZE, null);
  			}else {
  				g2.setColor(Color.CYAN);
  				g2.fillRect(x, y, TILE_SIZE, TILE_SIZE);
  			}
		}
		
		public void moveBy(int dRow, int dCol){
			this.row += dRow;
			this.col += dCol;
			
//			//moveUp
//			this.row = this.row - dRow;
//			
//			//moveDown
//			this.row = this.row + dRow;
//			
//			//moveLeft
//			this.col = this.col - dCol;
//			
//			//moveRight
//			this.col = this.col + dCol;
		}
		
		
	/*public void draw(Graphics2D g2) {
		// TODO: Draw the ball with fillOval(...)
		if (sprite != null) {
			g2.drawImage(sprite, x, y, 2*radius, 2*radius, null);
		} else {
		g2.setColor(Color.BLUE);
		g2.fillOval(x, y, 2*radius, 2*radius);
	}
	}*/
	
	/*public void shift(int dx) {
		// TODO: Update the ball's x-position
		  x += dx;
		  
		  if (x <=0) x = 0;
		  
		 // if (x + 2*radius > GameComponent.WIDTH) x = GameComponent.WIDTH - 2*radius;
	}
	public void reset() {
		// TODO: Move the ball back to its original position
		// Replace the current x with the original x
		this.x = this.startX;
	}
	public void update() {
	    x += dx;
	    y += dy;

	    // LEFT / RIGHT walls
	    if (x <= 0) {
	        x = 0;
	        dx = -dx;
	    }

	    if (x + 2 * radius >= GameComponent.WIDTH) {
	        x = GameComponent.WIDTH - 2 * radius;
	        dx = -dx;
	    }

	    // TOP / BOTTOM walls
	    if (y <= 0) {
	        y = 0;
	        dy = -dy;
	    }

	    if (y + 2 * radius >= GameComponent.HEIGHT) {
	        y = GameComponent.HEIGHT - 2 * radius;
	        dy = -dy;
	    }*/


}

