package dev.kaan.game.mainCodes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Scanner;

import dev.kaan.game.state.GameState;

public class Region {

	protected String regionName;
	private ArrayList<Integer> neighbours;
	public boolean isCapital;
	public int regionID;
	public int regionHP;
	protected int continentsID;
	public BufferedImage imageOfRegion;
	public int corx,cory,width,height;
	public Player owner;
	private GameState gameState;

	Scanner keyboard = new Scanner(System.in);

	public Region(String rName, int rID, int cID, int rHP, BufferedImage image,int x,int y,int w,int h) {	
		regionName = rName;
		corx=x; cory=y; width=w; height=h;
		regionHP = rHP;
		regionID = rID;
		continentsID = cID;
		neighbours = new ArrayList<Integer>();
		setNeighbours(cID, rID);
		isCapital = false;
		imageOfRegion=image;
	}
	public String HPtoString() {
		String text="";
		text+=regionHP+" HP";
		return text;
	}
	public void setNeighbours(int cID, int rID) {
		switch (cID) {
		case 1: // North America
			switch (rID) {
			case 1:
				neighbours.add(6);
				neighbours.add(32);
				break;
			case 2:
				neighbours.add(6);
				neighbours.add(7);
				neighbours.add(9);
				break;
			case 3:
				neighbours.add(4);
				neighbours.add(9);
				neighbours.add(13);
				break;
			case 4:
				neighbours.add(3);
				neighbours.add(7);
				neighbours.add(8);
				neighbours.add(9);
				break;
			case 5:
				neighbours.add(6);
				neighbours.add(7);
				neighbours.add(8);
				neighbours.add(21);
				break;
			case 6:
				neighbours.add(1);
				neighbours.add(2);
				neighbours.add(7);
				neighbours.add(5);
				break;
			case 7:
				neighbours.add(2);
				neighbours.add(4);
				neighbours.add(5);
				neighbours.add(6);
				neighbours.add(8);
				neighbours.add(9);
				break;
			case 8:
				neighbours.add(4);
				neighbours.add(5);
				neighbours.add(7);
				break;
			case 9:
				neighbours.add(2);
				neighbours.add(3);
				neighbours.add(4);
				neighbours.add(7);
				break;
			default:
				System.out.println("This region may not from North America.\nRemainder: There are only 42 countries!");
				break;
			}
			break;
		case 2: // South America
			switch (rID) {
			case 10:
				neighbours.add(12);
				neighbours.add(11);
				break;
			case 11:
				neighbours.add(12);
				neighbours.add(13);
				neighbours.add(10);
				neighbours.add(18);
				break;
			case 12:
				neighbours.add(11);
				neighbours.add(13);
				neighbours.add(10);
				break;
			case 13:
				neighbours.add(3);
				neighbours.add(12);
				neighbours.add(11);
				break;
			default:
				System.out.println("This region may not from South America.\nRemainder: There are only 42 countries!");
				break;
			}
			break;
		case 3: // Europe
			switch (rID) {
			case 20:
				neighbours.add(21);
				neighbours.add(22);
				neighbours.add(23);
				neighbours.add(26);
				break;
			case 21:
				neighbours.add(5);
				neighbours.add(20);
				neighbours.add(23);
				break;
			case 22:
				neighbours.add(20);
				neighbours.add(23);
				neighbours.add(25);
				neighbours.add(24);
				neighbours.add(26);
				break;
			case 23:
				neighbours.add(21);
				neighbours.add(20);
				neighbours.add(22);
				neighbours.add(25);
				break;
			case 24:
				neighbours.add(22);
				neighbours.add(25);
				neighbours.add(26);
				neighbours.add(16);
				neighbours.add(33);
				break;
			case 25:
				neighbours.add(23);
				neighbours.add(22);
				neighbours.add(24);
				neighbours.add(33);
				neighbours.add(27);
				neighbours.add(37);
				break;
			case 26:
				neighbours.add(20);
				neighbours.add(22);
				neighbours.add(24);
				neighbours.add(18);
				break;
			default:
				System.out.println("This region may not from Europe.\nRemainder: There are only 42 countries!");
				break;
			}
			break;
		case 4: // Africa
			switch (rID) {
			case 14:
				neighbours.add(18);
				neighbours.add(15);
				neighbours.add(19);
				break;
			case 15:
				neighbours.add(18);
				neighbours.add(16);
				neighbours.add(14);
				neighbours.add(19);
				neighbours.add(17);
				neighbours.add(33);
				break;
			case 16:
				neighbours.add(18);
				neighbours.add(15);
				neighbours.add(33);
				neighbours.add(24);
				break;
			case 17:
				neighbours.add(15);
				neighbours.add(19);
				break;
			case 18:
				neighbours.add(26);
				neighbours.add(16);
				neighbours.add(15);
				neighbours.add(14);
				neighbours.add(11);
				break;
			case 19:
				neighbours.add(14);
				neighbours.add(15);
				neighbours.add(17);
				break;
			default:
				System.out.println("This region may not from Africa.\nRemainder: There are only 42 countries!");
				break;
			}
			break;
		case 5: // Asia
			switch (rID) {
			case 27:
				neighbours.add(25);
				neighbours.add(37);
				neighbours.add(28);
				neighbours.add(29);
				neighbours.add(33);
				break;
			case 28:
				neighbours.add(34);
				neighbours.add(36);
				neighbours.add(37);
				neighbours.add(27);
				neighbours.add(29);
				neighbours.add(35);
				break;
			case 29:
				neighbours.add(35);
				neighbours.add(28);
				neighbours.add(27);
				neighbours.add(33);
				break;
			case 30:
				neighbours.add(34);
				neighbours.add(32);
				neighbours.add(38);
				neighbours.add(36);
				break;
			case 31:
				neighbours.add(34);
				neighbours.add(28);
				break;
			case 32:
				neighbours.add(1);
				neighbours.add(38);
				neighbours.add(30);
				neighbours.add(34);
				neighbours.add(31);
				break;
			case 33:
				neighbours.add(29);
				neighbours.add(27);
				neighbours.add(25);
				neighbours.add(24);
				neighbours.add(16);
				neighbours.add(15);
				break;
			case 34:
				neighbours.add(31);
				neighbours.add(32);
				neighbours.add(30);
				neighbours.add(36);
				neighbours.add(28);
				break;
			case 35:
				neighbours.add(40);
				neighbours.add(28);
				neighbours.add(29);
				break;
			case 36:
				neighbours.add(38);
				neighbours.add(30);
				neighbours.add(34);
				neighbours.add(28);
				neighbours.add(37);
				break;
			case 37:
				neighbours.add(36);
				neighbours.add(28);
				neighbours.add(27);
				neighbours.add(25);
				break;
			case 38:
				neighbours.add(32);
				neighbours.add(30);
				neighbours.add(36);
				break;
			default:
				System.out.println("This region may not from Asia.\nRemainder: There are only 42 countries!");
				break;
			}
			break;
		case 6: // Australia
			switch (rID) {
			case 39:
				neighbours.add(41);
				neighbours.add(42);
				break;
			case 40:
				neighbours.add(35);
				neighbours.add(41);
				neighbours.add(42);
				break;
			case 41:
				neighbours.add(40);
				neighbours.add(39);
				neighbours.add(42);
				break;
			case 42:
				neighbours.add(39);
				neighbours.add(40);
				neighbours.add(41);
				break;
			default:
				System.out.println("This region may not from Australia.\nRemainder: There are only 42 countries!");
				break;
			}
			break;
		default:
			System.out.println("There are only 6 continents!");
		}
	}

	public boolean isNeighbour(Region r2) {
		if (neighbours.contains(r2.regionID))
			return true;
		else
			return false;
	}

	
	public String toString() {
		String text = "";
		switch (continentsID) {
		case 1:
			if (isCapital)
				text += regionName + "*Capital* from North America with"+regionHP+ "\n";
			else
				text += regionName + " from North America with"+regionHP+ "\n";
			break;
		case 2:
			if (isCapital)
				text += regionName + "*Capital* from South America with "+regionHP+ "\n";
			else
				text += regionName + " from South America with "+regionHP+ "\n";
			
			break;
		case 3:
			if (isCapital)
				text += regionName + "*Capital* from Europe with "+regionHP+ " \n";
			else
				text += regionName + " from Europe with "+regionHP+ "\n";
			break;
		case 4:
			if (isCapital)
				text += regionName + "*Capital* from Africa with "+regionHP+ "\n";
			else
				text += regionName + " from Africa with "+regionHP+ "\n";
			break;
		case 5:
			if (isCapital)
				text += regionName + "*Capital* from Asia with "+regionHP+ "\n";
			else
				text += regionName + " from Asia with "+regionHP+ "\n";
			break;
		case 6:
			if (isCapital)
				text += regionName + "*Capital* from Australia with "+regionHP+ "\n";
			else
				text += regionName + " from Australia with "+regionHP+ "\n";
			
			break;
		}
		return text;
	}

	public void gifting() {
		int choosed = (int) (Math.random() * 3 + 1);
		System.out.println(
				"I choosed a random number between 1 and 3. If you know the number, i have a special gift for you ");
		int guess = keyboard.nextInt();
		if (guess == choosed) {
			System.out.println("Here is your gift:");
			Gift n = new Gift();
			int hpgift;
			System.out.println(n.selectgift());
			switch (n.giftid) {
			case 1:
			case 3:
				hpgift = -regionHP * 2 / 10;
				owner.currentHP += hpgift;

				break;
			case 2:
			case 4:
				hpgift = -regionHP * 3 / 10;
				owner.currentHP += hpgift;
				break;
			case 5:
			case 8:
				hpgift = 100;
				owner.currentHP += hpgift;
				break;

			case 6:
			case 9:
				hpgift = 300;
				owner.currentHP += hpgift;
				break;
			case 7:
			case 10:
				hpgift = 500;
				owner.currentHP += hpgift;
				break;

			default:
				break;
			}

		} else
			System.out.println("upss... I choosed " + choosed + "Sorry for bad luck.");

		System.out.println(owner.currentHP + " is total hp of the player");
	}

	
	public void setImageOfRegion(BufferedImage imageOfRegion) {
		this.imageOfRegion = imageOfRegion;
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	
}
