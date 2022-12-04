package GoBang;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;

public class GameUI {
	public static Group root;
	
	public void start()
	{
		root = new Group();
        Canvas canvas = new Canvas(800, 800);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        DrawUtils.drawShapes(gc);
        final Boolean[] who = {true};
        Pot pot = new Pot();
        canvas.setOnMouseClicked(e -> {
            // 鼠标左键单击
            if (e.getButton() == MouseButton.PRIMARY) {
                if (who[0]) {
                    gc.setFill(Color.RED);
                } else {
                    gc.setFill(Color.BLACK);
                }
                who[0] = !who[0];

                double sceneX = e.getSceneX();
                double sceneY = e.getSceneY();
                if (sceneX < 40 || sceneX > 800 || sceneY < 40 || sceneY > 800) {
                    return;
                }
                double x = getLocation(sceneX);
                double y = getLocation(sceneY);

                boolean b = pot.set(!who[0], x, y);
                if (!b) {
                    return;
                }
                gc.fillArc(x - 15, y - 15, 30, 30, 0, 360, ArcType.ROUND);//绘制完整的原型
                boolean valid = pot.valid(!who[0], x, y);
                if (valid) {
                    gc.setFont(new Font(28));
                    gc.strokeText("OVER", 300, 300);
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setTitle("game over");
                    alert.setContentText("game over " +(who[0] ? "Black win!!" : "RED win!!"));
					ButtonType yes = new ButtonType("Yes");
					alert.getButtonTypes().add(yes);
					alert.showAndWait();
					GoBangUIManager.gameOver();
                }
            } else if (e.getButton() == MouseButton.SECONDARY) {
                gc.clearRect(0, 0, 800, 800);
                pot.pots.clear();
                DrawUtils.drawShapes(gc);
            }
            //刷新，否则不能接收到键盘事件了
            canvas.requestFocus();
        });

        root.getChildren().add(canvas);
	}
	
    private double getLocation(double l) {
        double v = l % 40;
        double v1 = Math.floor(l / 40);
        return v > 20.0 ? v1 * 40 + 40 : v1 * 40;
    }
}
