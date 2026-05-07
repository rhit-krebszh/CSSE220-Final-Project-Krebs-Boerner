package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy {
	
	private int col, row;
	 private BufferedImage sprite;
	 
	  private static final int TILE_SIZE = 40;
	private int direction = 1;
	
	public Enemy(int row, int col) {
		this.row = row;
		this.col = col;
		
		
		 try {
	            sprite = ImageIO.read(Player.class.getResource("/model/zombie.png"));
	        } catch (IOException | IllegalArgumentException e) {
	            sprite = null;
	        }
	}
	
	public void drawOn(Graphics2D g2) {
        int x = this.col * TILE_SIZE;
        int y = this.row * TILE_SIZE;
		
        if (sprite != null) {
            g2.drawImage(sprite, x, y, TILE_SIZE, TILE_SIZE, null);
        } else {
        	g2.setColor(Color.RED);
    		g2.fillRect(col * 40, row * 40, 40, 40);
        }
		
	}
	
	public void update() {
		col += direction;
		
		if (col <= 0 || col >= 10) {
			direction *= -1;
		}
	}

}
