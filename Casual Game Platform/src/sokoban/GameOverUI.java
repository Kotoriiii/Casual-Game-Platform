package sokoban;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class GameOverUI {
	public static VBox root;
	
	public GameOverUI()
	{
		
	}
	
	public void start()
	{
		root = new VBox();
		root.setMinWidth(200);
		root.setMinHeight(200);
		root.setLayoutX(150);
		root.setLayoutY(150);
		root.setSpacing(20);
		root.setAlignment(Pos.CENTER);
		root.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY,null,null)));
		root.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null,BorderWidths.DEFAULT)));
		
		Button restartBtn = new Button("Restart");
		restartBtn.setOnMouseClicked(e->SokobanUIManager.restartGame());
		restartBtn.setMinWidth(70);
		restartBtn.setMinHeight(30);
		Button backBtn = new Button("Back");
		backBtn.setMinWidth(70);
		backBtn.setMinHeight(30);
		backBtn.setOnMouseClicked(e->SokobanUIManager.backToMenu());
		
		root.getChildren().addAll(restartBtn,backBtn);
		GameUI.root.getChildren().add(root);
	}
}
