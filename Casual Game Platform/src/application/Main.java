package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override 
	public void start(Stage primaryStage) {
		// TODO: write your code here
		GameMenu gameMenu = new GameMenu(primaryStage);
		gameMenu.start();

	}
	


	/**
	 * The main method is only needed for the IDE with limited JavaFX support.
	 * Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		// TODO: write your code here
		launch(args);
	}
	
	
	
}