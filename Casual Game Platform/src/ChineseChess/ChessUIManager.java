package ChineseChess;

import application.GameMenu;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ChessUIManager {
	
	private static Stage gameStage;
	
	public void init(Stage stage)
	{
		gameStage = stage;	
		GameUI gameUI = new GameUI();
		Scene scene = gameUI.start();

		scene.setOnMouseClicked(new PlayAction());
		gameStage.setResizable(true);
		gameStage.setTitle("Chinese Chess");
		gameStage.setScene(scene);
		gameStage.setX((Screen.getPrimary().getVisualBounds().getWidth()-scene.getWidth())/2);
		gameStage.setY((Screen.getPrimary().getVisualBounds().getHeight()-scene.getHeight())/2);
	}
	
	public static void restartGame()
	{
		GameUI gameUI = new GameUI();
		Scene scene = gameUI.start();

		scene.setOnMouseClicked(new PlayAction());
		gameStage.setScene(scene);
	}
	
	public static void gameOver()
	{
		GameOverUI gameOverUI = new GameOverUI();
		gameOverUI.start();
	}
	
	public static void backToMenu()
	{
		Stage menuStage = gameStage;
		GameMenu gameMenu = new GameMenu(menuStage);
		gameMenu.start();
	}
}
