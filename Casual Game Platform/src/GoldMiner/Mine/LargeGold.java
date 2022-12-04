package GoldMiner.Mine;

import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;

public class LargeGold extends Mine{ 

	private double positionX;
	private double positionY;
	
	public LargeGold(double positionX, double positionY, String picture, Pane root) {
		super(positionX, positionY, picture, root);
		// TODO Auto-generated constructor stub
		this.positionX = positionX;
		this.positionY = positionY;
	}

	@Override
	public int getPoint() {
		// TODO Auto-generated method stub
		return 500;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 78;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 79;
	}

	@Override
	public Rectangle2D getRec() {
		// TODO Auto-generated method stub
		return new Rectangle2D(positionX,positionY,78,79);
	}

}
