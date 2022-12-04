package sokoban;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Block {
	protected Image img;
	protected int x;
	protected int y;
	
	
	public abstract void setImg();
	
	public abstract void draw(GraphicsContext g2d);
	
	public void setX(int i) {
		this.x = i;
	}
	
	public void setY(int j) {
		this.y = j;
	}
}
