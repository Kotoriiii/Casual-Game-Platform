package sokoban;

import application.GameMenu;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class SokobanUIManager {
	private static Stage gameStage;
	
	public void init(Stage stage)
	{
		gameStage = stage;
		GameUI gameUI = new GameUI();
		gameUI.start();
		
		gameStage.setScene(GameUI.scene);
		gameStage.setTitle("Sokuban");
		gameStage.setResizable(false);
		gameStage.setX((Screen.getPrimary().getVisualBounds().getWidth()-GameUI.scene.getWidth())/2);
		gameStage.setY((Screen.getPrimary().getVisualBounds().getHeight()-GameUI.scene.getHeight())/2);
	}
	
	public static void restartGame()
	{
		GameUI gameUI = new GameUI();
		gameUI.start();
		gameStage.setScene(GameUI.scene);
	}
	
	public static void backToMenu()
	{
		Stage menuStage = gameStage;
		GameMenu gameMenu = new GameMenu(menuStage);
		gameMenu.start();
	}

	public static void gameOver() {
		GameOverUI gameOverUI = new GameOverUI();
		gameOverUI.start();
	}
}
