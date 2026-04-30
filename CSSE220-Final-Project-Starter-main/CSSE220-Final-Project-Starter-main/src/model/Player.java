package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Tier3Game.Ball;

public class Player {

	private int x, y, radius;
	private int startX; // we use this for storing initial values
	private int startY; // we use this for storing initial values
	BufferedImage sprite;
	
	
	public Player(int x, int y, int radius) {
		this.x = x - radius;
		this.y = y - radius;
		this.radius = radius;
		this.startX = x; // the initial position
		this.startY = y; // the initial position
	
	
		try {
			sprite = ImageIO.read(Player.class.getResource("tennis.png"));
		} catch (IOException e) {
			
			sprite = null;
		}
	
	
	
	
	
}
