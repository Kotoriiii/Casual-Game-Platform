package GoBang;

import application.GameMenu;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class GoBangUIManager {
	private static Stage gameStage;
	
	public void init(Stage stage)
	{
		gameStage = stage;
		GameUI gameUI = new GameUI();
		gameUI.start();
		
		Scene scene = new Scene(GameUI.root);
		gameStage.setScene(scene);
		gameStage.setTitle("Gobang");
		gameStage.setX((Screen.getPrimary().getVisualBounds().getWidth()-scene.getWidth())/2);
		gameStage.setY((Screen.getPrimary().getVisualBounds().getHeight()-scene.getHeight())/2);
	}
	
	public static void gameOver()
	{
		GameOverUI ui = new GameOverUI();
		ui.start();
	}
	
	public static void restartGame()
	{
		GameUI gameUI = new GameUI();
		gameUI.start();
		
		Scene scene = new Scene(GameUI.root);
		gameStage.setScene(scene);
		gameStage.setTitle("Gobang");
		gameStage.setX((Screen.getPrimary().getVisualBounds().getWidth()-scene.getWidth())/2);
		gameStage.setY((Screen.getPrimary().getVisualBounds().getHeight()-scene.getHeight())/2);
	}
	
	public static void backToMenu()
	{
		Stage menuStage = gameStage;
		GameMenu gameMenu = new GameMenu(menuStage);
		gameMenu.start();
	}
}
