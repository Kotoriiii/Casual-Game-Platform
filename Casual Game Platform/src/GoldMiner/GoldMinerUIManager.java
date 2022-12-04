package GoldMiner;

import application.GameMenu;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class GoldMinerUIManager {
	
	private static Stage gameStage;
	
	public void init(Stage stage)
	{
		gameStage = stage;
		
		GameUI gameUI = new GameUI("image/gameBG.png");
		gameUI.start();
		
		Scene scene = new Scene(GameUI.root,1280,946);
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>()
		{

			@Override
			public void handle(KeyEvent key) {
				// TODO Auto-generated method stub				
				if(key.getCode().equals(KeyCode.SPACE))
				{
					GameUI.captureStatus=1;
				}		
				if(key.getCode().equals(KeyCode.P))
				{
					GoldMinerUIManager.pause();
				}
			}
	
		});
		
		gameStage.setTitle("Gold Miner");
		gameStage.setScene(scene);
		gameStage.setX((Screen.getPrimary().getVisualBounds().getWidth()-1280)/2);
		gameStage.setY((Screen.getPrimary().getVisualBounds().getHeight()-946)/2);
	}
	
	public static void ChangeNextLevel()
	{
		GameUI newUI = new GameUI("image/gameBG.png");
		newUI.nextLevel();
		
		Scene scene = new Scene(GameUI.root,1280,946);
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>()
		{
			@Override
			public void handle(KeyEvent key) {
				// TODO Auto-generated method stub
				
				if(key.getCode().equals(KeyCode.SPACE))
				{
					GameUI.captureStatus=1;
				}
				if(key.getCode().equals(KeyCode.P))
				{
					GoldMinerUIManager.pause();
				}
			}
	
		});
		
		gameStage.setScene(scene);
	}
	
	public static void gameOver()
	{
		GameOverUI gameOverUI = new GameOverUI();
		gameOverUI.start();
	}
	
	public static void restartGame()
	{
		GameUI newUI = new GameUI("image/gameBG.png");
		newUI.start();
		
		Scene scene = new Scene(GameUI.root,1280,946);
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>()
		{
			@Override
			public void handle(KeyEvent key) {
				// TODO Auto-generated method stub
				
				if(key.getCode().equals(KeyCode.SPACE))
				{
					GameUI.captureStatus=1;
				}	
				if(key.getCode().equals(KeyCode.P))
				{
					GoldMinerUIManager.pause();
				}
			}
	
		});
		
		gameStage.setScene(scene);
	}
	
	public static void backToMenu()
	{
		Stage menuStage = gameStage;
		GameMenu gameMenu = new GameMenu(menuStage);
		gameMenu.start();
	}
	
	public static void pause()
	{
		PauseUI ui = new PauseUI();
		ui.start();
	}
	
}
