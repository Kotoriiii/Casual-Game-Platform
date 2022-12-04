package application;

import ChineseChess.ChessUIManager;
import sokoban.SokobanUIManager;
import GoBang.GoBangUIManager;
import GoldMiner.GoldMinerUIManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class GameMenu {
	
	private Stage stage;
	
	public GameMenu(Stage stage)
	{
		this.stage = stage;
	}
	
	public void start()
	{
		Label menuLabel = new Label("Casual Game Platform");
		menuLabel.setFont(new Font(30));
		menuLabel.setPadding(new Insets(60,0,20,0));
		Button goldMinerBtn = new Button("Gold Miner");
		goldMinerBtn.setOnAction(e->GoldMinerStart(stage));
		
		Button xxxGame = new Button("Go Bang");
		xxxGame.setOnAction(e->GoBangStart(stage));
		Button xxxGame2 = new Button("Chinese Chess");
		xxxGame2.setOnAction(e->ChineseChessStart(stage));
		Button xxxGame3 = new Button("Sokoban");
		xxxGame3.setOnAction(e->SokobanStart(stage));
		
		VBox mainMenu = new VBox();
		mainMenu.setAlignment(Pos.TOP_CENTER);
		mainMenu.getChildren().addAll(menuLabel,goldMinerBtn,xxxGame,xxxGame2,xxxGame3);
		mainMenu.setSpacing(50);
		
		Scene scene = new Scene(mainMenu,800,500);
		
		stage.setTitle("Casual Game Platform");
		stage.setScene(scene);
		stage.setX((Screen.getPrimary().getVisualBounds().getWidth()-800)/2);
		stage.setY((Screen.getPrimary().getVisualBounds().getHeight()-500)/2);
		stage.show();
	}
	
	public void GoldMinerStart(Stage stage)
	{
		GoldMinerUIManager ui = new GoldMinerUIManager();
		ui.init(stage);
	}
	
	public void GoBangStart(Stage stage)
	{
		GoBangUIManager ui = new GoBangUIManager();
		ui.init(stage);
	}
	
	public void ChineseChessStart(Stage stage)
	{
		ChessUIManager ui = new ChessUIManager();
		ui.init(stage);
	}
	
	public void SokobanStart(Stage stage)
	{
		SokobanUIManager ui = new SokobanUIManager();
		ui.init(stage);
	}

}
