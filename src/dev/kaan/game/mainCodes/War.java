package dev.kaan.game.mainCodes;

public class War {
	private Region attacker;
	private Region defender;
	
	public War (Dice a)
	{
		System.out.println("War is between " +attacker + " and " +defender);
	}

	public Region getAttacker() {
		return attacker;
	}

	public void setAttacker(Region attacker) {
		this.attacker = attacker;
	}
	

	
	public Region getDefender() {
		return defender;
	}

	public void setDefender(Region defender) {
		this.defender = defender;
	}
	
}
