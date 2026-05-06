package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy {
	
	private int x, y;
	private int startX; // we use this for storing initial values
	private int startY; // we use this for storing initial values
	BufferedImage sprite;
	private static final int TILE_SIZE = 40;
	private int col;
	private int row;
	
	public Enemy(int row, int col) {
		this.row = row;
		this.col = col;
		
		try {
			sprite = ImageIO.read(Player.class.getResource("zombie.png"));
		} catch (IOException e) {
			
			sprite = null;
			}
		}
	
	
	public void update() {
		col += direction;
		
		if (col <= 0 || col >= 10) {
			direction *= -1;
		}
	}
	
	public void drawOn(Graphics2D g2) {
		if (sprite != null) {
				g2.drawImage(sprite, x, y, TILE_SIZE, TILE_SIZE, null);
			}else {
				g2.setColor(Color.CYAN);
				g2.fillRect(x, y, TILE_SIZE, TILE_SIZE);
			}
		
	}

}
