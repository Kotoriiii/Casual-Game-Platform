package GoldMiner;

import java.util.ArrayList;
import java.util.Random;

import GoldMiner.Mine.Mine;
import javafx.scene.layout.Pane;

public class MineCreator {	
	
	private MineFactory mf = new MineFactory();
	private Mine mine = null;
	public static ArrayList<Mine> mineList = new ArrayList<Mine>();
	private Boolean isPlace = true;
	
	public void randomMineGenerated(Pane root)
	{
		double x = 0;
		double y = 0;
		int picture = 0;
		Random ran = new Random();
		
		for(int i = 0; i < 30; i++)
		{
			x = ran.nextDouble(0,1150);
			y = ran.nextDouble(300,900);
			picture = ran.nextInt(1,7);
					
			switch(picture)
			{
				case 1:
					mine = mf.getMine("LargeGold", x, y, root);
					break;
				case 2:
					mine = mf.getMine("MediumGold", x, y, root);
					break;
				case 3:
					mine = mf.getMine("SmallGold", x, y, root);
					break;
				case 4:
					mine = mf.getMine("Stone", x, y, root);
					break;
				case 5:
					mine = mf.getMine("Stone2", x, y, root);
					break;	
				case 6:
					if(GameUI.gamelevel>=3)
					{
						mine = mf.getMine("Diamond", x, y, root);
					}
					break;
			}
			
			for(Mine temp : mineList)
			{
				if(mine.getRec().intersects(temp.getRec()))
				{
					isPlace = false;
				}
			}
			
			if(isPlace)
			{
				mineList.add(mine);			
				mine.render();
			}
			else
			{
				isPlace = true;
				i--;
			}
			
		}
	}
}
