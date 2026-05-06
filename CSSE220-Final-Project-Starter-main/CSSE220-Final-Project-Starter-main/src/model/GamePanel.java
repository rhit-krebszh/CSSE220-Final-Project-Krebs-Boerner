package model;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import ui.GameComponent;

public class GamePanel extends JPanel{
	private GameComponent Canvas;
	
	public GamePanel(GameModel model) {
		Canvas = new GameComponent(model);
		
		this.setLayout(new BorderLayout());
		this.add(Canvas,BorderLayout.CENTER);
		
		this.addKeyListener(new KeyAdapter() {
	
		public void keyPressed(KeyEvent e) {
			//System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
			int key = e.getKeyCode();
			if (key==KeyEvent.VK_A) {
				// TODO: Move the ball left
				Canvas.move(-10);
			}
			else if (key==KeyEvent.VK_D) {
				// TODO: Move the ball right
				Canvas.move(10);
			}	
			else {
				// TODO: Reset the ball
				Canvas.center();
			}
	}
	});
	}
}
