package ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import model.GameModel;
import model.Player;

public class GameComponent extends JComponent {

	
	
	private GameModel model;

	public GameComponent(GameModel model) {
	this.model = model;
	
	
	}
	public GameComponent() {
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setBackground(); // note this only works with JPanels and will not work with JComponents
		this.setOpaque(true);
		
		
	

	Player player2 = new Player(0, 0, 0);
	try {
		background = ImageIO.read(this.getClass().getResource("background.png"));
	} catch (IOException e) {
		
		background = null; //fix -> finish, and use try catch lesson to update
	
	
	}
	@Override
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D)g;

	// Minimal placeholder to test  it’s running
	
	
	
	player2.draw(g2);
	//g2.drawString("Final Project Starter: UI is running ✅", 20, 30);

//add what does stuff
	// TODO: draw based on model state
	}
	public void move(int x) {
		
		// TODO: Move the ball horizontally by the given amount (x)
		// Hint: call the ball's shift(...) method
		player2.shift(x); //make player2 public
		repaint();
	}
	
	/**
	 * Moves the ball to its starting position
	 */
	public void center() {
		// TODO: Reset the ball to its starting position
		player2.reset();
		repaint();
	}	
	
}
