package GoldMiner.Mine;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class Mine {
	
	private double positionX;
	private double positionY;
	private String picture;
	private ImageView image;
	private Pane root;
	
	
	public Mine(double positionX, double positionY, String picture, Pane root)
	{
		this.positionX = positionX;
		this.positionY = positionY;
		this.picture = picture;
		this.root = root;
	}
	
	
	public double getPositionX()
	{
		return this.image.getLayoutX();
	}
	
	public double getPositionY()
	{
		return this.image.getLayoutY();
	}
	
	public void setPositionX(double positionX)
	{
		image.setLayoutX(positionX);
	}
	
	public void setPositionY(double positionY)
	{
		image.setLayoutY(positionY);
	}
	
	
	public void render()
	{
		image = new ImageView(picture);
		image.setLayoutX(positionX);
		image.setLayoutY(positionY);
		root.getChildren().add(image);
	}
	
	public abstract int getPoint();
	public abstract int getWidth();
	public abstract int getHeight();
	public abstract Rectangle2D getRec();
	
}
