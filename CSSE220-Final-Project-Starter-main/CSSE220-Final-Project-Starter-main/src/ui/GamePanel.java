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
			if (key==KeyEvent.VK_W) {
				// TODO: Move the ball up
				Canvas.move(-1,0);
			}
			else if (key==KeyEvent.VK_S) {
				// TODO: Move the ball down
				Canvas.move(1,0);
			}	
			else if (key==KeyEvent.VK_A) {
				// TODO: Move the ball down
				Canvas.move(0,-1);
			}
			else if (key==KeyEvent.VK_D) {
				// TODO: Move the ball down
				Canvas.move(0,1);
			}
			else {
				// TODO: Reset the ball
				Canvas.center();
			}
	}
	});
	}
}
