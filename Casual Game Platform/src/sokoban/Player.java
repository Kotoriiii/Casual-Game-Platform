package sokoban;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Player implements Drawable{
	private static int i = 3;
	private static int j = 4;
	private static String direction = "bottom";
	private Image img;
	
	public Player(int i, int j) {
		Player.i = i;
		Player.j = j;
	}

	public Player(){
		// TODO Auto-generated constructor stub
	}

	public void draw(GraphicsContext g2d) {
		this.setImg();
		Image way =new Image("image/way.png");
		g2d.drawImage(way,j*50,i*50,50,50);
		g2d.drawImage(img,j*50,i*50,50,50);
		// TODO Auto-generated method stub
		
	}

	public void setImg() {
		this.img = new Image("image/player_"+direction+".png");
		// TODO Auto-generated method stub	
	}
	
	public static int getX() {
		return i;
	}
	
	public static int getY() {
		return j;
	}
	
	public static void setX(int x) {
		i = x;
	}
	
	public static void setY(int y) {
		j = y;
	}
	
	public static String getDirection() {
		return direction;
	}
	
	public static void setDirection(String s) {
		direction = s;
	}

}
