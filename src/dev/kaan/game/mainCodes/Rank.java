package dev.kaan.game.mainCodes;

import java.util.ArrayList;

public class Rank {
	protected String rankName;
	ArrayList<Integer> checkers = new ArrayList<Integer>();
	int checker1 , checker2 ,checker3 = 0 ;
	
	
	public Rank(String rank)
	{
		
		rankName=rank;
		checkers.add(checker1);
		checkers.add(checker2);
		checkers.add(checker3);
		
	}
	public Rank()
	{
		
	}
	
	public void rankUp(Player rankp) 
	{
		int index =0;
		for (int j = 0; j < rankp.ranks.size(); j++) {
			if(rankp.currentRank.getRankName().equals(rankp.ranks.get(j).getRankName()))		
		index = j;
		}
		rankp.currentRank=rankp.ranks.get(index+1);
	}
	
	public void getPrizepool(Player prizep)
	{
		PrizePool p = new PrizePool();
		p.selectPrize(prizep);
	}
	
	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}
	public void getAchievement(int a , Player player)
	{
		Achievements achi = new Achievements();
		if(this.rankName.equals("Corporal"))
		{
			System.out.println(achi.GoalsOfRank1.get(a));
			System.out.println(checkers.get(a));
			achi.completeAchieve(this , player);
			
		}
		else if(this.rankName.equals("Sergeant"))
		{
			System.out.println(achi.GoalsOfRank2.get(a));
			System.out.println(checkers.get(a));
			achi.completeAchieve(this,player);
		}
		else if(this.rankName.equals("Liutenant"))
		{
			System.out.println(achi.GoalsOfRank3.get(a));
			System.out.println(checkers.get(a));
			achi.completeAchieve(this,player);
		}
		else if(this.rankName.equals("Captain"))
		{
			System.out.println(achi.GoalsOfRank4.get(a));
			System.out.println(checkers.get(a));
			achi.completeAchieve(this,player);
		}
		else if(this.rankName.equals("Major"))
		{
			System.out.println(achi.GoalsOfRank5.get(a));
			System.out.println(checkers.get(a));
			achi.completeAchieve(this,player);
		}
		
		
		
	}

	public void checkSituation(Player player)
	{
		int sayac = 0;
		Achievements achi = new Achievements();
		if(this.rankName.equals("Corporal"))
		{
			for (int i = 0; i <achi.GoalsOfRank1.size(); i++) {
				if(checkers.get(i) == 0)
				{
					System.out.println("You have to do:"+achi.GoalsOfRank1.get(i));
				sayac++;
				}
			}
				if(sayac==0)
					achi.completeAchieve(this , player);
				
					
			}
			
		else if(this.rankName.equals("Sergeant"))
		{
			for (int i = 0; i <achi.GoalsOfRank2.size(); i++) {
				if(checkers.get(i) == 0)
				{
					System.out.println("You have to do:"+achi.GoalsOfRank2.get(i));
				sayac++;
				}
			}
				if(sayac==0)
					achi.completeAchieve(this,player);
			
		}
		else if(this.rankName.equals("Liutenant"))
		{
			for (int i = 0; i <achi.GoalsOfRank3.size(); i++) {
				if(checkers.get(i) == 0)
				{
					System.out.println("You have to do:"+achi.GoalsOfRank3.get(i));
				sayac++;
				}
			}
				if(sayac==0)
					achi.completeAchieve(this,player);
				
		}
		else if(this.rankName.equals("Captain"))
		{
			for (int i = 0; i <achi.GoalsOfRank4.size(); i++) {
				if(checkers.get(i) == 0)
				{
					System.out.println("You have to do:"+achi.GoalsOfRank4.get(i));
				sayac++;
				}
			}
				if(sayac==0)
					achi.completeAchieve(this,player);
				
		}
		else if(this.rankName.equals("Major"))
		{
			for (int i = 0; i <achi.GoalsOfRank5.size(); i++) {
				if(checkers.get(i) == 0)
				{
					System.out.println("You have to do:"+achi.GoalsOfRank5.get(i));
				sayac++;
				}
			}
				if(sayac==0)
					achi.completeAchieve(this,player);
				
		}
			
		}
		
	}
	
	
