package GoldMiner.Mine;

import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;

public class SmallGold extends Mine{

	private double positionX;
	private double positionY;
	
	public SmallGold(double positionX, double positionY, String picture, Pane root) {
		super(positionX, positionY, picture, root);
		// TODO Auto-generated constructor stub
		this.positionX = positionX;
		this.positionY = positionY;
	}

	@Override
	public int getPoint() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 43;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 35;
	}

	@Override
	public Rectangle2D getRec() {
		// TODO Auto-generated method stub
		return new Rectangle2D(positionX,positionY,43,35);
	}

}
