package sokoban;

public class Map {
	private int level = 1;
	
	private int[][] map1 = new int[][]{
		{2,2,2,2,2,2,2,2,2,2},
		{2,2,2,2,2,2,2,2,2,2},
		{2,2,2,2,2,2,2,2,2,2},	
		{2,4,3,1,1,2,4,3,1,2},	
		{2,1,1,1,1,5,2,2,1,2},	
		{2,2,2,1,1,1,1,1,1,2},	
		{2,1,1,1,1,1,2,2,2,2},	
		{2,4,3,1,1,1,1,3,4,2},	
		{2,2,2,2,2,2,2,2,2,2},
		{2,2,2,2,2,2,2,2,2,2}
	};
	
	private int[][] record1 = new int[][]{
		{2,2,2,2,2,2,2,2,2,2},
		{2,2,2,2,2,2,2,2,2,2},
		{2,2,2,2,2,2,2,2,2,2},	
		{2,4,3,1,1,2,4,3,1,2},	
		{2,1,1,1,1,1,2,2,1,2},	
		{2,2,2,1,1,1,1,1,1,2},	
		{2,1,1,1,1,1,2,2,2,2},	
		{2,4,3,1,1,1,1,3,4,2},	
		{2,2,2,2,2,2,2,2,2,2},
		{2,2,2,2,2,2,2,2,2,2}
	};
	
	private int[][] map2 = new int[][]{
		{2,2,2,2,2,2,2,2,2,2},
		{2,1,1,1,2,2,2,2,2,2},
		{2,1,3,5,2,2,2,2,2,2},	
		{2,1,3,3,2,2,2,2,4,2},	
		{2,2,2,1,2,2,2,2,4,2},	
		{2,2,2,1,1,1,1,1,4,2},	
		{2,2,1,1,1,2,2,1,1,2},	
		{2,2,1,1,1,2,2,2,2,2},
		{2,2,2,2,2,2,2,2,2,2},
		{2,2,2,2,2,2,2,2,2,2}
	};

	private int[][] record2 = new int[][]{
		{2,2,2,2,2,2,2,2,2,2},
		{2,1,1,1,2,2,2,2,2,2},
		{2,1,3,1,2,2,2,2,2,2},	
		{2,1,3,3,2,2,2,2,4,2},	
		{2,2,2,1,2,2,2,2,4,2},	
		{2,2,2,1,1,1,1,1,4,2},	
		{2,2,1,1,1,2,2,1,1,2},	
		{2,2,1,1,1,2,2,2,2,2},
		{2,2,2,2,2,2,2,2,2,2},
		{2,2,2,2,2,2,2,2,2,2}
	};
	
	private int[][] map3 = new int[][]{
		{2,2,2,2,2,2,2,2,2,2},
		{2,2,2,2,2,2,2,2,2,2},
		{2,2,2,1,1,2,2,2,2,2},	
		{2,2,2,5,3,1,1,2,2,2},	
		{2,2,2,2,1,2,1,2,2,2},	
		{2,2,4,2,1,2,1,1,2,2},	
		{2,2,4,3,1,1,2,1,2,2},	
		{2,2,4,1,1,1,3,1,2,2},
		{2,2,2,2,2,2,2,2,2,2},
		{2,2,2,2,2,2,2,2,2,2}
	};

	private int[][] record3 = new int[][]{
		{2,2,2,2,2,2,2,2,2,2},
		{2,2,2,2,2,2,2,2,2,2},
		{2,2,2,1,1,2,2,2,2,2},	
		{2,2,2,1,3,1,1,2,2,2},	
		{2,2,2,2,1,2,1,2,2,2},	
		{2,2,4,2,1,2,1,1,2,2},	
		{2,2,4,3,1,1,2,1,2,2},	
		{2,2,4,1,1,1,3,1,2,2},
		{2,2,2,2,2,2,2,2,2,2},
		{2,2,2,2,2,2,2,2,2,2}
	};
	
	public Map() {
		// TODO Auto-generated constructor stub
	}

	public int getLevel() {
		return level;
	}
	
	public int[][] getMap(int[][] t) {
		if(this.level==1)
			for(int i=0;i<map1.length;i++) {
				for(int j=0;j<map1[0].length;j++) {
					t[i][j] = map1[i][j];
				}
			}
		else if(this.level==2)
			for(int i=0;i<map2.length;i++) {
				for(int j=0;j<map2[0].length;j++) {
					t[i][j] = map2[i][j];
				}
			}
		else
			for(int i=0;i<map3.length;i++) {
				for(int j=0;j<map3[0].length;j++) {
					t[i][j] = map3[i][j];
				}
			}
		return t;
	}
	
	public int[][] getRecord(int[][] t){
		if(this.level==1)
			for(int i=0;i<record1.length;i++) {
				for(int j=0;j<record1[0].length;j++) {
					t[i][j] = record1[i][j];
				}
			}
		else if(this.level==2)
			for(int i=0;i<record2.length;i++) {
				for(int j=0;j<record2[0].length;j++) {
					t[i][j] = record2[i][j];
				}
			}
		else
			for(int i=0;i<record3.length;i++) {
				for(int j=0;j<record3[0].length;j++) {
					t[i][j] = record3[i][j];
				}
			}
		return t;
	}
	
	public int setLevel(int level) {
		this.level = level;
		return this.level;
	}
	
	public int getPos() {
		if(this.level==1) {
			return 45;
		}else if(this.level==2) {
			return 23;
		}else {
			return 33;
		}
	}
	
}
