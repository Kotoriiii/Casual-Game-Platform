package GoldMiner;

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

public class PauseUI {
	
	public static VBox root;
	
	public void start()
	{
		GameUI.animation.pause();
		GameUI.refresh.stop();
		
		root = new VBox();
		root.setMinWidth(200);
		root.setMinHeight(200);
		root.setLayoutX(540);
		root.setLayoutY(273);
		root.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY,null,null)));
		
		Button continueBtn = new Button("Continue");
		continueBtn.setOnMouseClicked(e->close());
		continueBtn.setMinWidth(70);
		continueBtn.setMinHeight(30);
		Button backBtn = new Button("Menu");
		backBtn.setMinWidth(70);
		backBtn.setMinHeight(30);
		backBtn.setOnAction(e->GoldMinerUIManager.backToMenu());
		
		root.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null,BorderWidths.DEFAULT)));
		root.setSpacing(20);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(continueBtn,backBtn);
		GameUI.root.getChildren().addAll(root);
	}
	
	public void close()
	{
		GameUI.root.getChildren().remove(root);
		GameUI.animation.play();
		GameUI.refresh.start();
	}
}
