package ChineseChess;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class ChessPanel {
	private static final int WIDTH = 9;
	private static final int HEIGHT = 10;
	private static final int CELLWIDTH = 80;
	public static boolean isRedTurn = true;

	private static Image[] imgs = new Image[18];
	private static ImageView[][] imageViews = new ImageView[10][9]; // 10rows 9cols

	public static int[][] panel = new int[][] { { 1, 2, 3, 4, 5, 4, 3, 2, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 6, 0, 0, 0, 0, 0, 6, 0 }, { 7, 0, 7, 0, 7, 0, 7, 0, 7 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 17, 0, 17, 0, 17, 0, 17, 0, 17 }, { 0, 16, 0, 0, 0, 0, 0, 16, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 11, 12, 13, 14, 15, 14, 13, 12, 11 } };

	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}

	public static int getCellwidth() {
		return CELLWIDTH;
	}

	public void drawInitialChess(Group root){
//		ChessPanel chessPanel = new ChessPanel();
		// chess
		panel = new int[][] { { 1, 2, 3, 4, 5, 4, 3, 2, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 6, 0, 0, 0, 0, 0, 6, 0 }, { 7, 0, 7, 0, 7, 0, 7, 0, 7 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 17, 0, 17, 0, 17, 0, 17, 0, 17 }, { 0, 16, 0, 0, 0, 0, 0, 16, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 11, 12, 13, 14, 15, 14, 13, 12, 11 } };

		for (int i = 0; i < imgs.length; i++) {
			switch (i) {
			case 1:
				imgs[i] = new Image("image/b_c.png");
				break;
			case 2:
				imgs[i] = new Image("image/b_m.png");
				break;
			case 3:
				imgs[i] = new Image("image/b_x.png");
				break;
			case 4:
				imgs[i] = new Image("image/b_s.png");
				break;
			case 5:
				imgs[i] = new Image("image/b_j.png");
				break;
			case 6:
				imgs[i] = new Image("image/b_p.png");
				break;
			case 7:
				imgs[i] = new Image("image/b_z.png");
				break;

			case 11:
				imgs[i] = new Image("image/r_c.png");
				break;
			case 12:
				imgs[i] = new Image("image/r_m.png");
				break;
			case 13:
				imgs[i] = new Image("image/r_x.png");
				break;
			case 14:
				imgs[i] = new Image("image/r_s.png");
				break;
			case 15:
				imgs[i] = new Image("image/r_j.png");
				break;
			case 16:
				imgs[i] = new Image("image/r_p.png");
				break;
			case 17:
				imgs[i] = new Image("image/r_z.png");
				break;
			}
		}

		int[][] matrix = panel;
		for (int i = 0; i < matrix.length; i++) { // row
			for (int j = 0; j < matrix[0].length; j++) { // col
				if (matrix[i][j] != 0) {
					imageViews[i][j] = new ImageView(imgs[matrix[i][j]]);
					imageViews[i][j].setX(CELLWIDTH * j - CELLWIDTH / 2);
					imageViews[i][j].setY(CELLWIDTH * i - CELLWIDTH / 2);
					imageViews[i][j].setFitHeight(CELLWIDTH);
					imageViews[i][j].setFitWidth(CELLWIDTH);
					root.getChildren().add(imageViews[i][j]);
				}
			}
		}
	}

	public void drawChessPanel(GraphicsContext gc) {
		gc.setStroke(Color.BLACK);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				gc.strokeRect(i * CELLWIDTH, CELLWIDTH * j, CELLWIDTH, CELLWIDTH);
			}
		}
		gc.strokeRect(0, 4 * CELLWIDTH, 8 * CELLWIDTH, CELLWIDTH);
		for (int i = 0; i < 8; i++) {
			for (int j = 5; j < 9; j++) {
				gc.strokeRect(i * CELLWIDTH, CELLWIDTH * j, CELLWIDTH, CELLWIDTH);
			}
		}
		gc.strokeLine(3 * CELLWIDTH, 0, 5 * CELLWIDTH, 2 * CELLWIDTH);
		gc.strokeLine(5 * CELLWIDTH, 0, 3 * CELLWIDTH, 2 * CELLWIDTH);
		gc.strokeLine(3 * CELLWIDTH, 9 * CELLWIDTH, 5 * CELLWIDTH, 7 * CELLWIDTH);
		gc.strokeLine(5 * CELLWIDTH, 9 * CELLWIDTH, 3 * CELLWIDTH, 7 * CELLWIDTH);
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				if (panel[i][j] == 6 || panel[i][j] == 16 || panel[i][j] == 7 || panel[i][j] == 17) {

					if (j != 0) {
						gc.strokeLine(j * CELLWIDTH - 10, i * CELLWIDTH - 10, j * CELLWIDTH - 20, i * CELLWIDTH - 10);
						gc.strokeLine(j * CELLWIDTH - 10, i * CELLWIDTH - 10, j * CELLWIDTH - 10, i * CELLWIDTH - 20);
						gc.strokeLine(j * CELLWIDTH - 10, i * CELLWIDTH + 10, j * CELLWIDTH - 10, i * CELLWIDTH + 20);
						gc.strokeLine(j * CELLWIDTH - 10, i * CELLWIDTH + 10, j * CELLWIDTH - 20, i * CELLWIDTH + 10);
					}
					if (j != 8) {
						gc.strokeLine(j * CELLWIDTH + 10, i * CELLWIDTH - 10, j * CELLWIDTH + 20, i * CELLWIDTH - 10);
						gc.strokeLine(j * CELLWIDTH + 10, i * CELLWIDTH - 10, j * CELLWIDTH + 10, i * CELLWIDTH - 20);
						gc.strokeLine(j * CELLWIDTH + 10, i * CELLWIDTH + 10, j * CELLWIDTH + 20, i * CELLWIDTH + 10);
						gc.strokeLine(j * CELLWIDTH + 10, i * CELLWIDTH + 10, j * CELLWIDTH + 10, i * CELLWIDTH + 20);
					}
				}
			}
		}
	}

	public static void chessMove(int[] initPos, int[] targetPos) {
		
		// TODO Auto-generated method stub
		System.out.println("ChessMove");
		panel[targetPos[0]][targetPos[1]] = panel[initPos[0]][initPos[1]];
		panel[initPos[0]][initPos[1]] = 0;
		
		if (imageViews[targetPos[0]][targetPos[1]] != null) {
			imageViews[targetPos[0]][targetPos[1]].setImage(null);
		}
		imageViews[targetPos[0]][targetPos[1]] = imageViews[initPos[0]][initPos[1]];
		imageViews[initPos[0]][initPos[1]] = null;
		
		imageViews[targetPos[0]][targetPos[1]].setX(CELLWIDTH * targetPos[1] - CELLWIDTH / 2);
		imageViews[targetPos[0]][targetPos[1]].setY(CELLWIDTH * targetPos[0] - CELLWIDTH / 2);

		
	}

	public static void swapTurn() {
		isRedTurn = isRedTurn ? false : true;
	}

}
