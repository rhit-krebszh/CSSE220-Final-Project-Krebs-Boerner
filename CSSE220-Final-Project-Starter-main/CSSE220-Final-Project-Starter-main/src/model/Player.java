package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.imageio.ImageIO;

import ui.GameComponent;
import ui.GameWindow;

public class Player{

    private int row;
    private int col;

    private int startRow;
    private int startCol;
    private int dx = 3;
	private int dy = 2;

    private BufferedImage sprite;

    private static final int TILE_SIZE = 40;

    public Player(int x, int y) {
        
        this.col = x / TILE_SIZE;
        this.row = y / TILE_SIZE;

        this.startRow = row;
        this.startCol = col;

        try {
           
        	sprite = ImageIO.read(Player.class.getResource("/model/skull.png"));
        } catch (IOException | IllegalArgumentException e) {
            sprite = null;
        }
            
    }
    
    public void drawOn(Graphics2D g2) {
        int x = this.col * TILE_SIZE;
        int y = this.row * TILE_SIZE;

        // Draw square background, need to use tiles
        

        // Draw da ting
        if (sprite != null) {
            g2.drawImage(sprite, x, y, TILE_SIZE, TILE_SIZE, null);
        } else {
        	g2.setColor(Color.RED);
            g2.fillRect(x, y, TILE_SIZE, TILE_SIZE);
        }
    }

    public void moveBy(int dRow, int dCol) {
        row += dRow;
        col += dCol; 

        // columns
        if (col < 0) col = 0;
        if (col >= GameComponent.WIDTH / TILE_SIZE) {
            col = (GameComponent.WIDTH / TILE_SIZE) - 1;
//        if (col >= GameComponent.getWidth() / TILE_SIZE) {
//          col = (GameComponent.WIDTH / TILE_SIZE) - 1;
        }
        

        // rows
        if (row < 0) row = 0;
        if (row >= GameComponent.HEIGHT / TILE_SIZE) {
            row = (GameComponent.HEIGHT / TILE_SIZE) - 1;
        }//moveUp
//			this.row = this.row - dRow;
//			
//			//moveDown
//			this.row = this.row + dRow;
//			
//			//moveLeft
//			this.col = this.col - dCol;
//			
//			//moveRight
//			this.col = this.col + dCol;
    }

    public void reset() {
        this.row = startRow;
        this.col = startCol;
    }
    
//    public void update() {
//    	row += dx;
//    	col += dy;
//    	
//    	// LEFT / RIGHT walls
//	    if (row <= 0) {
//	        row = 0;
//	        dx = -dx;
//	    }
//
//		 if (col + 2 * col >= GameComponent.WIDTH) { col = GameComponent.WIDTH - 2 *
//		 col; dx = -dx; }
//
//	    // TOP / BOTTOM walls
//	    if (col <= 0) {
//	        col = 0;
//	        dy = -dy;
//	    }
//
//		
//		 if (col + 2 * col >= GameComponent.HEIGHT) { col = GameComponent.HEIGHT - 2 *
//		 col; dy = -dy; }
//    }
    
    public Rectangle getBounds() {
	    return new Rectangle(row, col, row * 2, col * 2);
	}

//	@Override
//	public boolean collidesWith(Collidable other) {
//		Player otherPlayer = (Player) other;
//		return this.getBounds().intersects(otherPlayer.getBounds());
//	}
}


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//			
		

//		public void reset() {
//			// TODO Auto-generated method stub
//			this.x = this.startX;
//		
		
		
	/*public void draw(Graphics2D g2) {
		// TODO: Draw the ball with fillOval(...)
		if (sprite != null) {
			g2.drawImage(sprite, x, y, 2*radius, 2*radius, null);
		} else {
		g2.setColor(Color.BLUE);
		g2.fillOval(x, y, 2*radius, 2*radius);
	}
	}*/
	
	/*public void shift(int dx) {
		// TODO: Update the ball's x-position
		  x += dx;
		  
		  if (x <=0) x = 0;
		  
		 // if (x + 2*radius > GameComponent.WIDTH) x = GameComponent.WIDTH - 2*radius;
	}
	public void reset() {
		// TODO: Move the ball back to its original position
		// Replace the current x with the original x
		this.x = this.startX;
	}
	public void update() {
	    x += dx;
	    y += dy;

	    // LEFT / RIGHT walls
	    if (x <= 0) {
	        x = 0;
	        dx = -dx;
	    }

	    if (x + 2 * radius >= GameComponent.WIDTH) {
	        x = GameComponent.WIDTH - 2 * radius;
	        dx = -dx;
	    }

	    // TOP / BOTTOM walls
	    if (y <= 0) {
	        y = 0;
	        dy = -dy;
	    }

	    if (y + 2 * radius >= GameComponent.HEIGHT) {
	        y = GameComponent.HEIGHT - 2 * radius;
	        dy = -dy;
	    }*/



