package dev.kaan.game.mainCodes;

import java.util.ArrayList;
import java.util.Random;

import dev.kaan.game.gfx.Assets;

public class Player {
	public int playerID;
	public ArrayList<Region> currentRegions;
	protected ArrayList<Rank> ranks;
	protected Rank currentRank;
	public int currentHP;
	public double multiplier =1.0;
	public int addition=0;

	public Player(int pID) {
		ranks = new ArrayList<Rank>();		
		createRanks(ranks);
		playerID = pID;
		currentRank = ranks.get(0);
		currentHP = 14000;
		currentRegions=new ArrayList<Region>();	
	}

	public void setCapital(Region newCapital) {
		newCapital.isCapital = true;
	}
	
	public String HPtoString() {
		String text="";
		text+=currentHP+" HP";
		return text;
	}
	public void enemyNeighbours(Player player, int countryID, ArrayList<Region> enemies)
	{
		for(int indexR=0;indexR<player.currentRegions.size();indexR++) {
			if(this.currentRegions.get(countryID-1).isNeighbour(player.currentRegions.get(indexR)))
			{
				if(!this.currentRegions.contains(player.currentRegions.get(indexR))) 
				{
					System.out.println("*Enemy Region(from player"+player.playerID+")*-> "+player.currentRegions.get(indexR).toString());
					enemies.add(player.currentRegions.get(indexR));
				}
			}
		
		}
	}
	
	public ArrayList<Rank> createRanks(ArrayList<Rank> ranks) {
		Rank Corporal = new Rank("Corporal");
		ranks.add(Corporal);
		Rank Sergeant = new Rank("Sergeant");
		ranks.add(Sergeant);
		Rank Lieutenant = new Rank("Lieutenant");
		ranks.add(Lieutenant);
		Rank Captain = new Rank("Captain");
		ranks.add(Captain);
		Rank Major = new Rank("Major");
		ranks.add(Major);
		return ranks;
	}

	public void showRegions() {
		System.out.println("******************************\n(" + currentRank.rankName + ")Player" + playerID + "'s regions are:\n");
		for (int b = 0; b < currentRegions.size(); b++)
			System.out.println(b + 1 + ") " + currentRegions.get(b).toString());
		System.out.println("******************************\n");
	}

	public void distributeRegions(ArrayList<Region> regions) { 
		int index=0;
		Random random=new Random();
		while (currentRegions.size() != 14) 
		{
				index=random.nextInt(regions.size());
					currentRegions.add(regions.get(index));
					currentRegions.get(currentRegions.size()-1).owner=this;
					regions.remove(index);		
		}
	}

	public void setRegions(ArrayList<Region> regions) {
		
		Region Alaska = new Region("Alaska", 1, 1, 1000,Assets.RedRegions.get(0),14,52,42,78);
		regions.add(Alaska);
		Region Alberta = new Region("Alberta", 2, 1, 1000,Assets.RedRegions.get(1),79,104,107,127);
		regions.add(Alberta);
		Region CentralAmerica = new Region("Central America", 3, 1, 1000,Assets.RedRegions.get(2),82,219,114,266);
		regions.add(CentralAmerica);
		Region EastUnitedStates = new Region("East United States", 4, 1, 1000,Assets.RedRegions.get(3),129,158,174,205);
		regions.add(EastUnitedStates);
		Region Greenland = new Region("Greenland", 5, 1, 1000,Assets.RedRegions.get(4),220,10,267,39);
		regions.add(Greenland);
		Region AmericanNorthWestRegion = new Region("American North Western Region", 6, 1, 1000,Assets.RedRegions.get(5),67,37,130,75);
		regions.add(AmericanNorthWestRegion);
		Region Ontario = new Region("Ontario", 7, 1, 1000,Assets.RedRegions.get(6),146,107,165,138);
		regions.add(Ontario);
		Region Quebec = new Region("Quebec", 8, 1, 1000,Assets.RedRegions.get(7),194,97,218,138);
		regions.add(Quebec);
		Region WesternUS = new Region("Western US", 9, 1, 1000,Assets.RedRegions.get(8),79,161,105,188);
		regions.add(WesternUS);

		Region Argentina = new Region("Argentina", 10, 2, 1000,Assets.RedRegions.get(9),180,402,194,466);
		regions.add(Argentina);
		Region Brazil = new Region("Brazil", 11, 2, 1000,Assets.RedRegions.get(10),170,321,247,372);
		regions.add(Brazil);
		Region Peru = new Region("Peru", 12, 2, 1000,Assets.RedRegions.get(11),148,332,187,387);
		regions.add(Peru);
		Region Venezuela = new Region("Venezuela", 13, 2, 1000,Assets.RedRegions.get(12),156,294,190,309);
		regions.add(Venezuela);

		Region Congo = new Region("Congo", 14, 4, 1000,Assets.RedRegions.get(13),418,390,452,424);
		regions.add(Congo);
		Region EastAfrica = new Region("East Africa", 15, 4, 1000,Assets.RedRegions.get(14),459,351,498,394);
		regions.add(EastAfrica);
		Region Egypt = new Region("Egypt", 16, 4, 1000,Assets.RedRegions.get(15),425,305,451,323);
		regions.add(Egypt);
		Region Madagascar = new Region("Madagascar", 17, 4, 1000,Assets.RedRegions.get(16),532,453,545,487);
		regions.add(Madagascar);
		Region NorthAfrica = new Region("North Africa", 18, 4, 1000,Assets.RedRegions.get(17),345,291,383,350);
		regions.add(NorthAfrica);
		Region SouthAfrica = new Region("South Africa", 19, 4, 1000,Assets.RedRegions.get(18),426,443,458,493);
		regions.add(SouthAfrica);

		Region England = new Region("England", 20, 3, 1000,Assets.RedRegions.get(19),313,131,347,181);
		regions.add(England);
		Region Iceland = new Region("Iceland", 21, 3, 1000,Assets.RedRegions.get(20),339,87,357,101);
		regions.add(Iceland);
		Region NorthEurope = new Region("North Europe", 22, 3, 1000,Assets.RedRegions.get(21),391,153,421,186);
		regions.add(NorthEurope);
		Region Scandinavia = new Region("Scandinavia", 23, 3, 1000,Assets.RedRegions.get(22),397,70,429,100);
		regions.add(Scandinavia);
		Region SouthEurope = new Region("South Europe", 24, 3, 1000,Assets.RedRegions.get(23),394,207,428,243);
		regions.add(SouthEurope);
		Region Ukraine = new Region("Ukraine", 25, 3, 1000,Assets.RedRegions.get(24),451,69,496,148);
		regions.add(Ukraine);
		Region WesternEurope = new Region("WesternEurope", 26, 3, 1000,Assets.RedRegions.get(25),333,204,360,255);
		regions.add(WesternEurope);

		Region Afghanistan = new Region("Afghanistan", 27, 5, 1000,Assets.RedRegions.get(26),530,165,571,209);
		regions.add(Afghanistan);
		Region China = new Region("China", 28, 5, 1000,Assets.RedRegions.get(27),612,183,671,246);
		regions.add(China);
		Region India = new Region("India", 29, 5, 1000,Assets.RedRegions.get(28),580,244,621,297);
		regions.add(India);
		Region Irkutsk = new Region("Irkutsk", 30, 5, 1000,Assets.RedRegions.get(29),653,99,692,136);
		regions.add(Irkutsk);
		Region Japan = new Region("Japan", 31, 5, 1000,Assets.RedRegions.get(30),760,147,788,200);
		regions.add(Japan);
		Region Kamchatka = new Region("Kamchatka", 32, 5, 1000,Assets.RedRegions.get(31),710,44,773,68);
		regions.add(Kamchatka);
		Region MiddleEast = new Region("Middle East", 33, 5, 1000,Assets.RedRegions.get(32),462,250,515,287);
		regions.add(MiddleEast);
		Region Mongolia = new Region("Mongolia", 34, 5, 1000,Assets.RedRegions.get(33),658,153,697,187);
		regions.add(Mongolia);
		Region Thailand = new Region("Thailand", 35, 5, 1000,Assets.RedRegions.get(34),663,294,690,322);
		regions.add(Thailand);
		Region Siberia = new Region("Siberia", 36, 5, 1000,Assets.RedRegions.get(35),669,37,704,64);
		regions.add(Siberia);
		Region Ural = new Region("Ural", 37, 5, 1000,Assets.RedRegions.get(36),567,53,584,128);
		regions.add(Ural);
		Region Yakutsk = new Region("Yakutsk", 38, 5, 1000,Assets.RedRegions.get(37),585,28,634,94);
		regions.add(Yakutsk);

		Region EasternAustralia = new Region("Eastern Australia", 39, 6, 1000,Assets.RedRegions.get(38),763,440,810,494);
		regions.add(EasternAustralia);
		Region Indonesia = new Region("Indonesia", 40, 6, 1000,Assets.RedRegions.get(39),658,388,703,416);
		regions.add(Indonesia);
		Region NewGuinea = new Region("New Guinea", 41, 6, 1000,Assets.RedRegions.get(40),744,374,772,394);
		regions.add(NewGuinea);
		Region WesternAustralia = new Region("Western Australia", 42, 6, 1000,Assets.RedRegions.get(41),705,460,733,504);
		regions.add(WesternAustralia);
	}
}
