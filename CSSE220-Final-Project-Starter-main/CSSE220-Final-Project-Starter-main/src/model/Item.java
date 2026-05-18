package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Item {
	
	private int row, col;
	private boolean collected = false;
	
	public Item(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public void draw(Graphics2D g2) {
		if (collected) return;
		
		g2.setColor(Color.YELLOW);
		g2.fillOval(col*40 + 10, row *40 + 10, 20, 20);
	}
	
	public boolean isCollected() {
		return collected;
	}
	public void collect() {
		collected = true;
	}
	
	public int getRow() {return row;}
	public int getCol() {return col;}

}
