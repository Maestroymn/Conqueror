package dev.kaan.game.mainCodes;

public class Gift {
	int giftid;
	String[] badreasons = { "In the area rebelians attacked to the army, ", "due to the bad weather your army get sick, " };
	String[] goodreasons = { "You found enemy forces and they beg you to join your army, ",
			"Civils are happy to fall of previous government, " };
	String[] badconsequences = { "You lost %20 of your HP ", "You lost %30 of your HP " };
	String[] goodconsequences = { "You gain 100 HP", "You gain 300 HP", "You gain 500 HP" };

	public String selectgift() {
		String Gift = "";
		double key = Math.random();
		double keyforgoodconsequences = Math.random();
		

		if (key > 0.75) {
			Gift += badreasons[0];
			if (Math.random() > 0.5)
			{
				Gift += badconsequences[0];
				giftid=1;
			}
				
			else
			{
				Gift += badconsequences[1];
				giftid=2;
			}
				
		} else if (key > 0.5) {
			Gift += badreasons[1];
			if (Math.random() > 0.5)
			{
				Gift += badconsequences[0];
				giftid=3;
			}
				
			else
			{
				Gift += badconsequences[1];
				giftid=4;
			}
				
		} else if (key > 0.25) {
			Gift += goodreasons[0];
			if (keyforgoodconsequences > 0.67)
			{
				Gift += goodconsequences[0];
				giftid=5;
			}
				
			else if (keyforgoodconsequences > 0.33)
			{
				Gift += goodconsequences[1];
				giftid=6;
			}
				
			else
			{
				Gift += goodconsequences[2];
				giftid=7;
			}
				

		} else {
			Gift += goodreasons[1];
			if (keyforgoodconsequences > 0.67)
			{
				Gift += goodconsequences[0];
				giftid=8;
			}
				
			else if (keyforgoodconsequences > 0.33)
			{
				Gift += goodconsequences[1];
				giftid=9;
			}
				
			else
			{
				Gift += goodconsequences[2];
				giftid=10;
			}
				
		}

		return Gift;
	}

}
