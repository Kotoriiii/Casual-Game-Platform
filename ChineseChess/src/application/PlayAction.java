package application;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;

class PlayAction implements EventHandler<MouseEvent> {
	boolean isFirstClick = true;
	int initPos[] = null;
	int targetPos[] = null;
	
	private boolean isGameOver(int[] targetPos) {
//		System.out.println("Game?" + ChessPanel.panel[targetPos[0]][targetPos[1]]);
		if (ChessPanel.panel[targetPos[0]][targetPos[1]] == 5 || ChessPanel.panel[targetPos[0]][targetPos[1]] == 15) {
			return true;
		}
		return false;
	}
	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
		int cell = ChessPanel.getCellwidth();

		double x = event.getX(); // horizontal
		double y = event.getY(); // vertical

		int j = (int) (x - cell / 2) / cell;// horizontal
		int i = (int) (y - cell / 2) / cell;// vertical
		// out of bound
		if (i >= ChessPanel.getHeight() || j >= ChessPanel.getWidth()) {
			return;
		}
		// synchronize problem
		// first Click
		if (ChessPanel.panel[i][j] != 0 && isFirstClick == true) {// 点击有效
			initPos = new int[] { i, j };
			if (isSameSide(initPos)) {
				isFirstClick = false;
			}
//			System.out.println("FirstClick");
//			System.out.println("i" + i + "j" + j + "chessType" + ChessPanel.panel[i][j]);
			return;
		}
		// Second Click
		if (isFirstClick == false) {
			targetPos = new int[] { i, j };
			if (!isSameSide(targetPos)) {
				System.out.println(isValidMove(initPos, targetPos));
				if (isValidMove(initPos, targetPos)) {
					boolean isGameOver = isGameOver(targetPos);
					isFirstClick = true;
					ChessPanel.chessMove(initPos, targetPos);
					if (isGameOver) {
						gameOver();
					}
					;
					ChessPanel.swapTurn();
				}
			}
//			System.out.println("SecondClick");
//			System.out.println("i" + i + "j" + j + "chessType" + ChessPanel.panel[i][j]);

			return;
		}

	}

	private void gameOver() {
		// TODO Auto-generated method stub
		 Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("ChineseChess");
         alert.setHeaderText("GameOver");

         String msg = (ChessPanel.isRedTurn?"RED":"BLACK") +" Wins!";
         alert.setContentText(msg);
         alert.showAndWait().ifPresent(response -> {
             if (response == ButtonType.OK) {
                System.exit(0);
             }
         });
	}
	private boolean isRedChess(int[] pos) {
		if (ChessPanel.panel[pos[0]][pos[1]] > 10) {
			return true;
		}
		return false;
	}

	private boolean isBlackChess(int[] pos) {
		if (ChessPanel.panel[pos[0]][pos[1]] < 10 && ChessPanel.panel[pos[0]][pos[1]] > 0) {
			return true;
		}
		return false;
	}

	private boolean isSameSide(int[] pos) {
		if (ChessPanel.isRedTurn == true && isRedChess(pos)) {
			return true;
		}
		if (ChessPanel.isRedTurn == false && isBlackChess(pos)) {
			return true;
		}
		return false;
	}

	private boolean isEnemyChess(int[] pos) {
		if (ChessPanel.isRedTurn == true && isBlackChess(pos)) {
			return true;
		}
		if (ChessPanel.isRedTurn == false && isRedChess(pos)) {
			return true;
		}
		return false;
	}

	private boolean isValidMove(int[] initPos, int[] targetPos) {

		if (isSameSide(targetPos)) {
			return false;
		}

		// che
		if (ChessPanel.panel[initPos[0]][initPos[1]] == 1 || ChessPanel.panel[initPos[0]][initPos[1]] == 11) {
			if (targetPos[0] == initPos[0]) {
				int min = Math.min(initPos[1], targetPos[1]);
				int max = Math.max(initPos[1], targetPos[1]);
				for (int j = min + 1; j < max; j++) {
					if (ChessPanel.panel[initPos[0]][j] != 0) {
						return false;
					}
				}
				return true;
			} else if (targetPos[1] == initPos[1]) {
				int min = Math.min(initPos[0], targetPos[0]);
				int max = Math.max(initPos[0], targetPos[0]);
				for (int i = min + 1; i < max; i++) {
					if (ChessPanel.panel[i][initPos[1]] != 0) {
						return false;
					}
				}
				return true;
			}
		}
		// pao
		if (ChessPanel.panel[initPos[0]][initPos[1]] == 6 || ChessPanel.panel[initPos[0]][initPos[1]] == 16) {
			// normal move
			if (ChessPanel.panel[targetPos[0]][targetPos[1]] == 0) {
				if (targetPos[0] == initPos[0]) {
					int min = Math.min(initPos[1], targetPos[1]);
					int max = Math.max(initPos[1], targetPos[1]);
					for (int j = min + 1; j < max; j++) {
						if (ChessPanel.panel[initPos[0]][j] != 0) {
							return false;
						}
					}
					return true;
				} else if (targetPos[1] == initPos[1]) {
					int min = Math.min(initPos[0], targetPos[0]);
					int max = Math.max(initPos[0], targetPos[0]);
					for (int i = min + 1; i < max; i++) {
						if (ChessPanel.panel[i][initPos[1]] != 0) {
							return false;
						}
					}
					return true;
				}
			}
			// attack
			if (targetPos[0] == initPos[0]) {
				int min = Math.min(initPos[1], targetPos[1]);
				int max = Math.max(initPos[1], targetPos[1]);
				boolean isFlag = false;
				for (int j = min + 1; j < max; j++) {
					if (ChessPanel.panel[initPos[0]][j] != 0) {
						if (isFlag == false) {
							isFlag = true;
						} else {
							return false;
						}
					}
				}
				return true;
			} else if (targetPos[1] == initPos[1]) {
				int min = Math.min(initPos[0], targetPos[0]);
				int max = Math.max(initPos[0], targetPos[0]);
				boolean isFlag = false; //
				for (int i = min + 1; i < max; i++) {
					if (ChessPanel.panel[i][initPos[1]] != 0) {
						if (isFlag == false) {
							isFlag = true;
						} else {
							return false;
						}
					}
				}
				return true;
			}
		}
		// ma
		if (ChessPanel.panel[initPos[0]][initPos[1]] == 2 || ChessPanel.panel[initPos[0]][initPos[1]] == 12) {

			if (targetPos[0] == initPos[0] - 2) {
				if (targetPos[1] == initPos[1] - 1 || targetPos[1] == initPos[1] + 1) {
					if (ChessPanel.panel[initPos[0] - 1][initPos[1]] == 0) {
						return true;
					}
					return false;
				}
			}
			if (targetPos[0] == initPos[0] + 2) {
				if (targetPos[1] == initPos[1] - 1 || targetPos[1] == initPos[1] + 1) {
					if (ChessPanel.panel[initPos[0] + 1][initPos[1]] == 0) {
						return true;
					}
					return false;
				}
			}
			if (targetPos[1] == initPos[1] - 2) {
				if (targetPos[0] == initPos[0] - 1 || targetPos[0] == initPos[0] + 1) {
					if (ChessPanel.panel[initPos[0]][initPos[1] - 1] == 0) {
						return true;
					}
					return false;
				}
			}
			if (targetPos[1] == initPos[1] + 2) {
				if (targetPos[0] == initPos[0] - 1 || targetPos[0] == initPos[0] + 1) {
					if (ChessPanel.panel[initPos[0]][initPos[1] + 1] == 0) {
						return true;
					}
					return false;
				}
			}
		}
		// xiang
		if (ChessPanel.panel[initPos[0]][initPos[1]] == 3 || ChessPanel.panel[initPos[0]][initPos[1]] == 13) {
			// out of bound
			if (ChessPanel.isRedTurn == true) {
				if (targetPos[0] < 5) {
					return false;
				}
			} else {
				if (targetPos[0] >= 5) {
					return false;
				}
			}

			if (targetPos[0] == initPos[0] - 2 && targetPos[1] == initPos[1] - 2) {
				if (ChessPanel.panel[initPos[0] - 1][initPos[1] - 1] == 0) {
					return true;
				}
				return false;
			}
			if (targetPos[0] == initPos[0] - 2 && targetPos[1] == initPos[1] + 2) {
				if (ChessPanel.panel[initPos[0] - 1][initPos[1] + 1] == 0) {
					return true;
				}
				return false;
			}
			if (targetPos[0] == initPos[0] + 2 && targetPos[1] == initPos[1] - 2) {
				if (ChessPanel.panel[initPos[0] + 1][initPos[1] - 1] == 0) {
					return true;
				}
				return false;
			}
			if (targetPos[0] == initPos[0] + 2 && targetPos[1] == initPos[1] + 2) {
				if (ChessPanel.panel[initPos[0] + 1][initPos[1] + 1] == 0) {
					return true;
				}
				return false;
			}
		}
		// shi
		if (ChessPanel.panel[initPos[0]][initPos[1]] == 4 || ChessPanel.panel[initPos[0]][initPos[1]] == 14) {
			if (Math.abs(targetPos[0] - initPos[0]) == 1 && Math.abs(targetPos[1] - initPos[1]) == 1) {
				if (ChessPanel.isRedTurn) {
					if (7 <= targetPos[0] && targetPos[0] <= 9 && 3 <= targetPos[1] && targetPos[1] <= 5) {
						return true;
					}
				} else {
					if (0 <= targetPos[0] && targetPos[0] <= 2 && 3 <= targetPos[1] && targetPos[1] <= 5) {
						return true;
					}
				}
			}
		}
		//jiang
		if (ChessPanel.panel[initPos[0]][initPos[1]] == 5 || ChessPanel.panel[initPos[0]][initPos[1]] == 15) {
			if ((Math.abs(targetPos[0] - initPos[0]) == 1 && Math.abs(targetPos[1] - initPos[1]) == 0) || (Math.abs(targetPos[0] - initPos[0]) == 0 && Math.abs(targetPos[1] - initPos[1]) == 1)) {
				if (ChessPanel.isRedTurn) {
					if (7 <= targetPos[0] && targetPos[0] <= 9 && 3 <= targetPos[1] && targetPos[1] <= 5) {
						return true;
					}
				} else {
					if (0 <= targetPos[0] && targetPos[0] <= 2 && 3 <= targetPos[1] && targetPos[1] <= 5) {
						return true;
					}
				}
			}
		}
		//zu
		if (ChessPanel.panel[initPos[0]][initPos[1]] == 7 || ChessPanel.panel[initPos[0]][initPos[1]] == 17) {
			if ((Math.abs(targetPos[0] - initPos[0]) == 1 && Math.abs(targetPos[1] - initPos[1]) == 0) || (Math.abs(targetPos[0] - initPos[0]) == 0 && Math.abs(targetPos[1] - initPos[1]) == 1)) {
				if (ChessPanel.isRedTurn) {
					if (initPos[0] == 6 && targetPos[0] == 5) {
						return true;
					}
					if (initPos[0] <=5 && targetPos[0] <= initPos[0]) {
						return true;
					}
				} else {
					if (initPos[0] == 3 && targetPos[0] == 4) {
						return true;
					}
					if (initPos[0] >=4 && targetPos[0] >= initPos[0]) {
						return true;
					}
				}
			}
		}
		return false;
	}

}