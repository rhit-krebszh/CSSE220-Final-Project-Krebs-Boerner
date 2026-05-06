package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Enemy {
	
	private int col, row;
	private int direction = 1;
	
	public Enemy(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public void update() {
		col += direction;
		
		if (col <= 0 || col >= 10) {
			direction *= -1;
		}
	}
	
	public void drawOn(Graphics2D g2) {
		g2.setColor(Color.RED);
		g2.fillRect(col * 40, row * 40, 40, 40);
	}

}
