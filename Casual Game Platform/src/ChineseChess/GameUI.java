package ChineseChess;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameUI {

	public static Group root;
	
	public Scene start()
	{
		root = new Group();
		root.setTranslateX(100);
		root.setTranslateY(100);
		Scene scene = new Scene(root, Color.WHITE);

		Canvas canvas = new Canvas(800, 800);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		ChessPanel ui = new ChessPanel();
		ui.drawChessPanel(gc);
		ui.drawInitialChess(root);

		root.getChildren().add(canvas);

		scene.setOnMouseClicked(new PlayAction());
		
		return scene;
	}
}
