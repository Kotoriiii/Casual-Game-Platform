package GoldMiner;

import GoldMiner.Mine.Diamond;
import GoldMiner.Mine.LargeGold;
import GoldMiner.Mine.MediumGold;
import GoldMiner.Mine.Mine;
import GoldMiner.Mine.SmallGold;
import GoldMiner.Mine.Stone;
import GoldMiner.Mine.Stone2;
import javafx.scene.layout.Pane;

public class MineFactory {
	
	public Mine getMine(String mineType, double positionX, double positionY, Pane root)
	{
		String picture;
		
		if(mineType == "LargeGold")
		{
			picture = "image/gold_large.png";
			return new LargeGold(positionX,positionY,picture,root);
		}
		else if(mineType == "MediumGold")
		{
			picture = "image/gold_medium.png";
			return new MediumGold(positionX,positionY,picture,root);
		}
		if(mineType == "SmallGold")
		{
			picture = "image/gold_small.png";
			return new SmallGold(positionX,positionY,picture,root);
		}
		if(mineType == "Stone")
		{
			picture = "image/stone1.png";
			return new Stone(positionX,positionY,picture,root);
		}
		if(mineType=="Stone2")
		{
			picture = "image/stone2.png";
			return new Stone2(positionX,positionY,picture,root);
		}
		if(mineType=="Diamond")
		{
			picture = "image/diamond.png";
			return new Diamond(positionX,positionY,picture,root);
		}
		
		return null;
	}
}
