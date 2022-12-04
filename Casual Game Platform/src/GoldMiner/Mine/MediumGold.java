package GoldMiner.Mine;

import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;

public class MediumGold extends Mine {

	private double positionX;
	private double positionY;
	
	public MediumGold(double positionX, double positionY, String picture, Pane root) {
		super(positionX, positionY, picture, root);
		// TODO Auto-generated constructor stub
		this.positionX = positionX;
		this.positionY = positionY;
	}

	@Override
	public int getPoint() {
		// TODO Auto-generated method stub
		return 300;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 52;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 48;
	}

	@Override
	public Rectangle2D getRec() {
		// TODO Auto-generated method stub
		return new Rectangle2D(positionX,positionY,52,48);
	}

}
