package ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

//import model.GameModel;
/**
 * GameWindow owns the frame
 **/
public class GameWindow {
	
	private JFrame frame;
	private GamePanel panel;
    private static final int TILE_SIZE = 40;

	public GameWindow() { //pass model
		
//		GameComponent comp = new GameComponent(this.model);
//		this.frame.add(comp);
		
//		comp.setFocusable(true);
//		comp.requestFocusInWindow();
//
//		comp.addKeyListener(new KeyAdapter() {
//		    public void keyPressed(KeyEvent e) {
//		        if (e.getKeyCode() == KeyEvent.VK_A) {
//		            comp.move(-10,0);
//		        } else if (e.getKeyCode() == KeyEvent.VK_D) {
//		            comp.move(10,0);
//		        }
//		    }
//		});
		
		this.frame = new JFrame("CSSE220 Final Project");
		this.panel = new GamePanel();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setContentPane(this.panel);
		this.frame.setSize((TILE_SIZE*15)+15, (TILE_SIZE*15)+38);
		this.frame.setLocationRelativeTo(null);
	}

	public void show() {
		this.frame.setVisible(true);
		}
}
