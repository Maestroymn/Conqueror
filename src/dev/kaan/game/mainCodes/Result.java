package dev.kaan.game.mainCodes;

public class Result {


	
	public void attackwin()
	{
		System.out.println("Attacking side dominated the area, One more round of attack is possible\n");
	}
	
	public void defencewin()
	{
		System.out.println("Defending side repulse the enemy, End of the round.\n");
	}
	public void tie()
	{
		System.out.println("Nobody get hurt, End of the round.\n");
	}
	
	public void attackconquer()
	{
		
		System.out.println("Defending side is destroyed by Attacking Side, Good Game\n");
		
	}
	
	public void defenceconquer()
	{
		System.out.println("Enemy is repulsed to their other areas, You are the BEAST , congratulations! you conquer the enemy area\n");

	}
}
