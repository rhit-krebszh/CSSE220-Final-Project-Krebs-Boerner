package ui;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	private GameComponent Canvas;
	
	public GamePanel() {
		Canvas = new GameComponent();
		
		this.setLayout(new BorderLayout());
		this.add(Canvas,BorderLayout.CENTER);
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		
		this.addKeyListener(new KeyAdapter() {
	
		@Override
		public void keyPressed(KeyEvent e) {
			//System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
			int key = e.getKeyCode();
			if (key==KeyEvent.VK_A) {
				// TODO: Move the ball left
				Canvas.move(-10,0);
			}
			else if (key==KeyEvent.VK_D) {
				// TODO: Move the ball right
				Canvas.move(10,0);
			}	
			else {
				// TODO: Reset the ball
				Canvas.center();
			}
	}
	});
	}
}
