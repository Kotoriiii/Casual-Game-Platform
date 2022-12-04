package GoBang;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawUtils {
    public static void drawShapes(GraphicsContext gc) {
        gc.setStroke(Color.GREY);
        gc.setLineWidth(1);

        for (int i = 40; i < 800; i = i + 40) {
            gc.strokeLine(i, 40, i, 760);
        }

        for (int i = 40; i < 800; i = i + 40) {
            gc.strokeLine(40, i, 760, i);
        }

    }
}
