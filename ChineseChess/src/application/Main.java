package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {

		Group root = new Group();
		root.setTranslateX(100);
		root.setTranslateY(100);
		Scene scene = new Scene(root, Color.WHITE);

		final Canvas canvas = new Canvas(900, 1000);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		ChessPanel.drawChessPanel(gc);
		ChessPanel.drawInitialChess(root);

		root.getChildren().add(canvas);

		scene.setOnMouseClicked(new PlayAction());

		primaryStage.setResizable(true);
		primaryStage.setTitle("");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}

