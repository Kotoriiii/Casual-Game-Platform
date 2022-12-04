package GoldMiner;

import GoldMiner.Mine.Mine;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Player {
	
	private double positionX;
	private double positionY;
	private String picture;
	private GraphicsContext gc;
	private Image image;
	private double length = 100;
	private double n = 0.5;
	private int dir = 1;
	private double endX;
	private double endY;
	private Line line;
	private ImageView hook;
	private Mine captureMine;
	private int i = 1;
	public static Timeline reelAnimation;
	
	public Player(double positionX, double positionY, String picture, GraphicsContext gc)
	{
		this.positionX = positionX;
		this.positionY = positionY;
		this.picture = picture;
		this.gc = gc;
	}
	
	public void drawCaptureLine(Pane root)
	{
		root.getChildren().remove(line);
		root.getChildren().remove(hook);	
		
		line = new Line(610, 110, endX,endY);
		hook = new ImageView("image/hook.png");
		hook.setLayoutX(endX-20);
		hook.setLayoutY(endY-5);
		
		switch(GameUI.captureStatus)
		{
			case 0:
				if(n < 0.1)
				{
					dir = 1;
				}
				else if(n > 0.9)
				{
					dir = -1;
				}
				n+=0.005*dir;

				endX = 610 + length*Math.cos(n*Math.PI);
				endY = 110 + length*Math.sin(n*Math.PI);
			break;
			case 1:
				if(length<1000)
				{
					length+=5;
					endX = 610 + length*Math.cos(n*Math.PI);
					endY = 110 + length*Math.sin(n*Math.PI);		
					line = new Line(610, 110, endX,endY);
					hook.setLayoutX(endX-20);
					hook.setLayoutY(endY-5);
				}
				else
				{
					GameUI.captureStatus=2;
				}
			break;
			case 2:
				if(length > 100)
				{
					length-=5;
					endX = 610 + length*Math.cos(n*Math.PI);
					endY = 110 + length*Math.sin(n*Math.PI);		
					line = new Line(610, 110, endX,endY);
					hook.setLayoutX(endX-20);
					hook.setLayoutY(endY-5);
				}
				else
				{
					GameUI.captureStatus=0;
				}
			break;
			case 3:
				if(length > 100)
				{
					reelAnimation.play();
					length-=2;
					endX = 610 + length*Math.cos(n*Math.PI);
					endY = 110 + length*Math.sin(n*Math.PI);		
					line = new Line(610, 110, endX,endY);
					captureMine.setPositionX(endX-captureMine.getWidth()/2);
					captureMine.setPositionY(endY+10);
				}
				else
				{
					reelAnimation.stop();
					image = new Image("image/miner1.png");
					gc.drawImage(image, positionX,positionY);
					GameUI.point+=captureMine.getPoint();
					captureMine.setPositionX(-150);
					captureMine.setPositionY(-150);
					GameUI.captureStatus=0;
				}
				
				
		}
		
		root.getChildren().add(line);
		root.getChildren().add(hook);
		
	}
	
	public void captureMine()
	{
		for(Mine mine : MineCreator.mineList)
		{
			if(endX > mine.getPositionX() && endX < mine.getPositionX()+mine.getWidth() 
			&& endY > mine.getPositionY() && endY < mine.getPositionY()+mine.getHeight())
			{
				GameUI.captureStatus = 3;
				captureMine = mine;
				break;
			}
				
		}
	}
	
	public void reel()
	{
		if(i==2)
		{
			i = 0;
		}
		i++;
		image = new Image("image/miner"+i+".png");
		gc.drawImage(image, positionX,positionY);
	}
	
	public void start()
	{
		image = new Image(picture);
		gc.drawImage(image, positionX,positionY);
		reelAnimation = new Timeline(new KeyFrame(Duration.millis(100),e->reel()));
		reelAnimation.setCycleCount(Timeline.INDEFINITE);
	}
	
	public void update(Pane root)
	{
		this.drawCaptureLine(root);
		this.captureMine();
	}
	
	
}
