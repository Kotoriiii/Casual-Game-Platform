package GoldMiner;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class GameUI {
	
	public static Pane root;
	
	private String picture;
	public static Refresh refresh;
	private Player player;
	public static Timeline animation;
	
	private Canvas canvas = new Canvas(1280,946);
	private GraphicsContext gc = canvas.getGraphicsContext2D();
	private Label scoreLabel;
	private Label goalLabel;
	private Label timeLabel;
	private Label levelLabel;
	public static int goalPoint;
	public static int point = 0;
	private MineCreator mc = new MineCreator();
	public static int captureStatus;
	public static int nextGoalScoreRate;
	public static int time;
	private int second = 1;
	public static int gamelevel;

	
	public GameUI(String picture)
	{
		this.picture = picture;
	}
	
	public void start()
	{
		GameUI.time = 60;
		GameUI.point = 0;	
		GameUI.goalPoint = 1000;
		GameUI.nextGoalScoreRate = 0;
		GameUI.captureStatus = 0;
		GameUI.gamelevel=1;
		
		root = new Pane();
		root.getChildren().add(canvas);
		refresh = new Refresh();
			
		this.setBG();
		this.setScorelabel();
		this.setPlayer();
		this.setTime();
		this.setLevelLabel();
		player.drawCaptureLine(root);
		mc.randomMineGenerated(root);
		refresh.start();
	}
	
	public void nextLevel()
	{	
		GameUI.gamelevel+=1;
		GameUI.time = 60;
		GameUI.nextGoalScoreRate+=1;
		GameUI.goalPoint+=1000*GameUI.nextGoalScoreRate;
		
		root = new Pane();
		root.getChildren().add(canvas);
		refresh = new Refresh();
		
		this.setBG();
		this.setScorelabel();
		this.setPlayer();
		this.setTime();
		this.setLevelLabel();
		MineCreator.mineList.clear();
		mc.randomMineGenerated(root);
		refresh.start();
	}
	
	public void setScorelabel()
	{
		scoreLabel = new Label();
		scoreLabel.setFont(new Font(20));
		scoreLabel.setLayoutX(30);
		scoreLabel.setLayoutY(20);
		goalLabel = new Label("Goal Money $" + goalPoint);
		goalLabel.setFont(new Font(20));
		goalLabel.setLayoutX(30);
		goalLabel.setLayoutY(80);
		root.getChildren().addAll(scoreLabel,goalLabel);
	}
	
	public void setLevelLabel()
	{
		levelLabel = new Label();
		levelLabel.setFont(new Font(30));
		levelLabel.setLayoutX(1100);
		levelLabel.setLayoutY(80);
		root.getChildren().add(levelLabel);
	}
	
	public void setTime()
	{
		timeLabel = new Label("Time : " + GameUI.time);
		timeLabel.setFont(new Font(30));
		timeLabel.setLayoutX(1100);
		timeLabel.setLayoutY(20);
		root.getChildren().add(timeLabel);
		
		animation = new Timeline(new KeyFrame(Duration.millis(1000),e->timeUpdate()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}

	
	public void setBG()
	{
		Image image = new Image(picture);
		gc.drawImage(image, 0, 0);	
	}
	
	public void setPlayer()
	{
		player = new Player(580,25,"image/miner1.png",gc);
		player.start();
	}
	
	public void update()
	{
		scoreLabel.setText("Money $" + GameUI.point);
		levelLabel.setText("Level " + GameUI.gamelevel);
		
		if(GameUI.point >= GameUI.goalPoint)
		{
			refresh.stop();
			animation.stop();
			Player.reelAnimation.stop();
			GoldMinerUIManager.ChangeNextLevel();
		}
	}
	
	public void timeUpdate()
	{
		if(GameUI.time!=0)
		{
			GameUI.time-=second;
			timeLabel.setText("Time : " + GameUI.time);
		}
		else
		{
			refresh.stop();
			animation.stop();
			Player.reelAnimation.stop();
			Alert alert = new Alert(AlertType.NONE);
			alert.setHeaderText("Time is up!");
			alert.setContentText("The score you get is " + point);
			ButtonType y = new ButtonType("yes");
			alert.getButtonTypes().add(y);
			alert.show();
			GoldMinerUIManager.gameOver();
		}
	}
	
	
	class Refresh extends AnimationTimer
	{

		@Override
		public void handle(long arg0) {
			// TODO Auto-generated method stub
			player.update(root);
			update();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
