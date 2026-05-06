package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;
import javax.swing.JComponent;
import javax.swing.JPanel;

import model.GameModel;
import model.Player;



public class GameComponent extends JPanel {
	
	private GameModel model;
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	public static final Color BG = Color.CYAN;
	public static final Color FG = Color.BLACK;
	BufferedImage background;
	private Timer timer;
	
	private Player player;
	public static final int TILE_SIZE = 40;

	public GameComponent() {
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setBackground(BG);
		this.setOpaque(true);
		
		model = new GameModel();
	
	try {
		background = ImageIO.read(getClass().getResource("background.png"));
	} catch(IOException e) {
		background = null;
	}
	
	new Timer(30, e ->{ //look in to how to change
		model.update();
		repaint();
	}).start();
	
	}
//	public GameComponent() {
//		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
//		this.setBackground(); // note this only works with JPanels and will not work with JComponents
//		this.setOpaque(true);
		
		
	

//	Player player2 = new Player(0, 0, 0);
//	try {
//		background = ImageIO.read(this.getClass().getResource("background.png"));
//	} catch (IOException e) {
//		
//		background = null; //fix -> finish, and use try catch lesson to update
	
	
	//}
	@Override
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D)g;
	
	if (background != null) {
		g2.drawImage(background, 0, 0, WIDTH, HEIGHT,null);
	} else {
		g2.setColor(FG);
	}

	// Minimal placeholder to test  it’s running
//	player.drawOn(g2);
	
	model.getPlayer().drawOn(g2);
	model.getEnemy().drawOn(g2);
	//g2.drawString("Final Project Starter: UI is running ✅", 20, 30);

//add what does stuff
	// TODO: draw based on model state
	}
	public void move(int dRow, int dCol) {
		
		// TODO: Move the ball horizontally by the given amount (x)
		// Hint: call the ball's shift(...) method
		
//		if (x < 0) {
//			model.getPlayer().moveBy(0, -1);
//		} else {
//			model.getPlayer().moveBy(0, 1);
//		}
//		player.moveBy(dRow, dCol);

		
		player.moveBy(dRow, dCol);
		//player2.shift(x); //make player2 public
		repaint();
	}
	
	/**
	 * Moves the ball to its starting position
	 */
	public void center() {
		// TODO: Reset the ball to its starting position
		player.reset();
		repaint();
	}	
	
}
	

