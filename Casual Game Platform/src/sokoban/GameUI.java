package sokoban;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class GameUI {
	
	public static AnchorPane root;
	public static Scene scene;
	static Map m = new Map();
	private int[][] map = new int[10][10];//游戏操作的地图
	private int[][] record = new int[10][10];//作为参考的地图
	static Player p = new Player();
	private static int x = Player.getX();
	private static int y = Player.getY();
	
	public void start()
	{
		try {
			root = new AnchorPane();
			scene = new Scene(root,500,500);
			m.setLevel(1);
			map = m.getMap(map);
			record = m.getRecord(record);
			game(root,scene);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void game(AnchorPane root, Scene scene) {
		Canvas canvas = new Canvas(map[0].length*50,map.length*50);
		GraphicsContext g2d = canvas.getGraphicsContext2D();
		drawMap(g2d);
		root.getChildren().add(canvas);
		play(scene,g2d);
	}
	
	
	
	private void levelUp() {
		int level = m.getLevel();
		m.setLevel(level+1);
		map = m.getMap(map);//游戏操作的地图
		record = m.getRecord(record);//作为参考的地图
	}
	
	private void win(GraphicsContext g2d) {
		boolean win = true;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (record[i][j]==4&&map[i][j]!=3) {
					win = false;
				}
			}
		}
		if (win) {
			Alert alert = new Alert(AlertType.NONE);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("You win!");
			if(m.getLevel()==3) {
				ButtonType y = new ButtonType("OK");
				alert.getButtonTypes().add(y);
				alert.showAndWait();
				SokobanUIManager.gameOver();
			}else{
				ButtonType y = new ButtonType("Next level");
				alert.getButtonTypes().add(y);
				alert.showAndWait();
				levelUp();
				drawMap(g2d);
			}
		}
	}

	
	
	
	private void play(Scene scene, GraphicsContext g2d) {
		//场景添加键盘事件
		scene.setOnKeyPressed(new EventHandler<Event>() {
			public void handle(Event event) {
				KeyEvent ke = (KeyEvent)event;
				KeyCode code = ke.getCode();
				switch (code) {
				case UP:
					Player.setDirection("top");
					//direction  = "top";
					//通道和目标点
					if (map[x-1][y]==1||map[x-1][y]==4) {
						//1.将玩家当前位置还原
						if (record[x][y]==4) {
							map[x][y] = 4;
						}else {
							map[x][y] = 1;
						}
						//3.将玩家移动过去
						map[x-1][y] = 5;
						//4.记录玩家的当前坐标
						x-=1;
						drawMap(g2d);
					}
					//如果是箱子
					if (map[x-1][y]==3) {
						//继续判断箱子的上边
						//如果是通道或目标点
						if (map[x-1-1][y]==1||map[x-1-1][y]==4) {
							//移动玩家
							if (record[x][y]==4) {
								map[x][y] = 4;
							}else {
								map[x][y] = 1;
							}
							//3.将玩家移动过去
							map[x-1][y] = 5;
							//4.记录玩家的当前坐标
							//移动箱子
							//1.将箱子当前的位子不需要还原
							//3.移动箱子
							map[x-1-1][y] = 3;
							x-=1;
							drawMap(g2d);
							win(g2d);
						}
					}
					break;
				case DOWN:
					Player.setDirection("bottom");
					//direction  = "bottom";
					//通道和目标点
					if (map[x+1][y]==1||map[x+1][y]==4) {
						if (record[x][y]==4) {
							map[x][y] = 4;
						}else {
							map[x][y] = 1;
						}
						//3.将玩家移动过去
						map[x+1][y] = 5;
						//4.记录玩家的当前坐标
						x+=1;
						drawMap(g2d);
					}
					//如果是箱子
					if (map[x+1][y]==3) {
						//继续判断箱子的上边
						//如果是通道或目标点
						if (map[x+1+1][y]==1||map[x+1+1][y]==4) {
							//移动玩家
							if (record[x][y]==4) {
								map[x][y] = 4;
							}else {
								map[x][y] = 1;
							}
							//3.将玩家移动过去
							map[x+1][y] = 5;
							//4.记录玩家的当前坐标
							//移动箱子
							//1.将箱子当前的位子不需要还原
							//3.移动箱子
							map[x+1+1][y] = 3;
							x+=1;
							drawMap(g2d);
							win(g2d);
						}
					}
					break;
				case LEFT:
					Player.setDirection("left");
					//direction  = "left";
					//通道和目标点
					if (map[x][y-1]==1||map[x][y-1]==4) {
						if (record[x][y]==4) {
							map[x][y] = 4;
						}else {
							map[x][y] = 1;
						}
						//3.将玩家移动过去
						map[x][y-1] = 5;
						//4.记录玩家的当前坐标
						y-=1;
						drawMap(g2d);
						break;
					}
					//如果是箱子
					if (map[x][y-1]==3) {
						//继续判断箱子的上边
						//如果是通道或目标点
						if (map[x][y-1-1]==1||map[x][y-1-1]==4) {
							//移动玩家
							if (record[x][y]==4) {
								map[x][y] = 4;
							}else {
								map[x][y] = 1;
							}
							//3.将玩家移动过去
							map[x][y-1] = 5;
							//移动箱子
							//1.将箱子当前的位子不需要还原
							//3.移动箱子
							map[x][y-1-1] = 3;
							//4.记录玩家的当前坐标
							y-=1;
							//重画
							drawMap(g2d);
							win(g2d);
						}
					}
					break;
				case RIGHT:
					Player.setDirection("right");
					//direction  = "right";
					//通道和目标点
					if (map[x][y+1]==1||map[x][y+1]==4) {
						if (record[x][y]==4) {
							map[x][y] = 4;
						}else {
							map[x][y] = 1;
						}
						//3.将玩家移动过去
						map[x][y+1] = 5;
						//4.记录玩家的当前坐标
						y+=1;
						drawMap(g2d);
						break;
					}
					//如果是箱子
					if (map[x][y+1]==3) {
						//继续判断箱子的上边
						//如果是通道或目标点
						if (map[x][y+1+1]==1||map[x][y+1+1]==4) {
							//移动玩家
							if (record[x][y]==4) {
								map[x][y] = 4;
							}else {
								map[x][y] = 1;
							}
							//3.将玩家移动过去
							map[x][y+1] = 5;
							
							//移动箱子
							//1.将箱子当前的位子不需要还原
							//3.移动箱子
							map[x][y+1+1] = 3;
							//4.记录玩家的当前坐标
							y+=1;
							drawMap(g2d);
							win(g2d);
						}
					}
					break;
				case R:
					for (int i = 0; i < map.length; i++) {
						for (int j = 0; j < map[i].length; j++) {
							map[i][j] = record[i][j];
						}
					}
					int pos = m.getPos();					
					map[pos/10][pos%10] = 5;
					Player.setDirection("bottom");
					drawMap(g2d);
					win(g2d);
					break;
				case P:
					Alert alert = new Alert(AlertType.NONE);
					alert.setTitle("Pause");
					alert.setHeaderText(null);
					alert.setContentText("Difficult level: "+m.getLevel()+"\nClick yes to continue");
					ButtonType y = new ButtonType("Yes");
					alert.getButtonTypes().add(y);
					alert.showAndWait();
					break;
				default:
					break;
				}
			}
		});
		
	}

	
	
	
	private void drawMap(GraphicsContext g2d) {
		Land l = new Land();
		Wall w = new Wall();
		End e = new End();
		Box b = new Box();
		Way a = new Way();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				l.setX(i);
				l.setY(j);
				w.setX(i);
				w.setY(j);
				e.setX(i);
				e.setY(j);
				b.setX(i);
				b.setY(j);
				a.setX(i);
				a.setY(j);
				switch (map[i][j]) {
				case 0:
					l.draw(g2d);;
					break;
				case 1:
					a.draw(g2d);
					break;
				case 2:
					w.draw(g2d);
					break;
				case 3:
					a.draw(g2d);
					b.draw(g2d);
					break;
				case 4:
					a.draw(g2d);
					e.draw(g2d);
					break;
				case 5:
					Player.setX(i);
					Player.setY(j);
					x = i;
					y = j;
					p.draw(g2d);
					break;
				default:
					break;
				}
			}
		}
	}
}
