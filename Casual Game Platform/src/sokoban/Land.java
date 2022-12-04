package sokoban;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Land extends Block implements Drawable{

	@Override
	public void setImg() {
		img =new Image("image/land.png");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(GraphicsContext g2d) {
		this.setImg();
		g2d.drawImage(img,y*50,x*50,50,50);
		// TODO Auto-generated method stub		
	}
	
	
	public void setX(int i) {
		this.x = i;
	}
	
	public void setY(int j) {
		this.y = j;
	}

}
