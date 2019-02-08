package dev.kaan.game.mainCodes;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class Dice {
	public static boolean conquer=false,eleminate=false;
	Scanner keyboard = new Scanner(System.in);
	Result r = new Result();

	public int RollDice() {
		int facevalue = (int) (Math.random() * 6) + 1;
		return facevalue;
	}

	/*
	 * public int attackingdice(Region att) { Scanner keyboard = new
	 * Scanner(System.in);
	 * 
	 * Dice firstatt = new Dice(); Dice secondatt = new Dice(); Dice thirdatt = new
	 * Dice(); int dice1 = firstatt.RollDice(); int dice2 = secondatt.RollDice();
	 * int dice3 = thirdatt.RollDice();
	 * System.out.println("ATTACKING PLAYER ROUND");
	 * 
	 * 
	 * Arrays.sort(attdices); int attackpoint=(int)((attdices[1] +
	 * attdices[2])*att.owner.multiplier)+att.owner.addition;
	 * att.owner.multiplier=1.0; att.owner.addition=0; return attackpoint; }
	 * 
	 * public int defendingdice() { Dice firstdef = new Dice(); Dice seconddef = new
	 * Dice(); int dice4 = firstdef.RollDice(); int dice5 = seconddef.RollDice();
	 * System.out.println("DEFENDING PLAYER ROUND");
	 * System.out.println("In order to rolldice press 'e'"); String input
	 * =keyboard.nextLine(); while(!input.equalsIgnoreCase("e")) {
	 * System.out.println("Press 'e' you are only hope of your citizens"); input
	 * =keyboard.nextLine();
	 * 
	 * } int[] defdices = { dice4, dice5 }; for (int i = 0; i < defdices.length;
	 * i++) { System.out.println("defence side rolled\ndie" + (i + 1) + ":" +
	 * defdices[i]); } System.out.println();
	 * 
	 * return dice4 + dice5; }
	 */

	public int calculateDmg(Region attack, Region defence, int damage) {
		int dmg = damage * 50;
		System.out.println("damage is " + dmg);
		if (dmg >= 100) {
			if (attack.owner.currentRank.getRankName().equals("Corporal")
					&& attack.owner.currentRank.checkers.get(1) == 0) {
				attack.owner.currentRank.checkers.set(1, 1);
			}

		}
		if (dmg >= 200) {
			if (attack.owner.currentRank.getRankName().equals("Sergeant")
					&& attack.owner.currentRank.checkers.get(1) == 0) {
				attack.owner.currentRank.checkers.set(1, 1);
			}

		}
		if (dmg >= 300) {
			if (attack.owner.currentRank.getRankName().equals("Lieutenant")
					&& attack.owner.currentRank.checkers.get(1) == 0) {
				attack.owner.currentRank.checkers.set(1, 1);
			}

		}
		if (dmg >= 400) {
			if (attack.owner.currentRank.getRankName().equals("Captain")
					&& attack.owner.currentRank.checkers.get(1) == 0) {
				attack.owner.currentRank.checkers.set(1, 1);
			}

		}
		if (dmg >= 400) {
			if (attack.owner.currentRank.getRankName().equals("Major")
					&& attack.owner.currentRank.checkers.get(1) == 0) {
				attack.owner.currentRank.checkers.set(1, 1);
			}

		}

		return dmg;
	}

	public void hitDmg(Region attack, Region defence, int damage) {

		if (attack.owner.currentRank.getRankName().equals("Sergeant") && attack.owner.currentRank.checkers.get(2) == 0
				&& attack.owner.currentRegions.size() == 17)
			attack.owner.currentRank.checkers.set(2, 1);
		else if (attack.owner.currentRank.getRankName().equals("Lieutenant")
				&& attack.owner.currentRank.checkers.get(2) == 0 && attack.owner.currentRegions.size() == 22)
			attack.owner.currentRank.checkers.set(2, 1);
		else if (attack.owner.currentRank.getRankName().equals("Captain")
				&& attack.owner.currentRank.checkers.get(2) == 0 && attack.owner.currentRegions.size() == 30)
			attack.owner.currentRank.checkers.set(2, 1);
		else if (attack.owner.currentRank.getRankName().equals("Major") && attack.owner.currentRank.checkers.get(2) == 0
				&& attack.owner.currentRegions.size() == 40)
			attack.owner.currentRank.checkers.set(2, 1);
		int dmg = calculateDmg(attack, defence, damage);

		if (dmg > 0) {
			defence.regionHP -= dmg;
			defence.owner.currentHP -= dmg;
			if (defence.regionHP <= 0) {
				if (defence.isCapital) // ele geçirilen bölge baþkent ise
				{
					eleminate=true;
					defence.owner.currentHP=0;
					if (attack.owner.currentRank.getRankName().equals("Major")
							&& attack.owner.currentRank.checkers.get(0) == 0) {
						attack.owner.currentRank.checkers.set(0, 1);
					}
					

					attack.owner.currentRank.checkers.set(0, attack.owner.currentRank.checkers.get(0) + 1);
					r.attackconquer();

																					// player due to conquer of capital
																					// city

				} else {
					conquer=true;
					attack.owner.currentRank.checkers.set(0, attack.owner.currentRank.checkers.get(0) + 1);
					r.attackconquer();
				}


			} else {
				if (attack.owner.currentRank.getRankName().equals("Corporal")
						&& attack.owner.currentRank.checkers.get(2) == 0) {
					attack.owner.currentRank.checkers.set(2, 1);
				}

				r.attackwin();

			}

		} else if (dmg == 0) {
			r.tie();

		} else {
			attack.regionHP += dmg;
			attack.owner.currentHP += dmg;
			if (attack.regionHP <= 0) {
				if (attack.isCapital) // ele geçirilen bölge baþkent ise
				{
					attack.owner.currentHP=0;
					if (defence.owner.currentRank.getRankName().equals("Major")
							&& defence.owner.currentRank.checkers.get(0) == 0) {
						defence.owner.currentRank.checkers.set(0, 1);
					}

					defence.owner.currentRank.checkers.set(0, defence.owner.currentRank.checkers.get(0) + 1);
					r.defenceconquer();

																					// player due to conquer of capital
																					// city



				} else {
					r.defenceconquer();

				}
			}

			else {
				r.defencewin();


			}

		}

	}
}
