package dev.kaan.game.mainCodes;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PrizePool  {

	Scanner keyboardx = new Scanner(System.in);

	ArrayList<String> Prizes = new ArrayList<String>();
	String prize1 = "+25 HP";
	String prize2 = "+50 HP";
	String prize3 = "Next Dice Shot";
	String prize4 = "-25 HP From the Region of Your Choice";
	String prize5 = "+75 HP";
	String prize6 = "+100 HP";
	String prize7 = "-50 HP From the Region of Your Choice";
	String prize8 = "-75 HP From the Region of Your Choice";
	String prize9 = "-100 HP From the Region of Your Choice";
	String prize10 = "1.25*Damage (If you can attack)";
	String prize11 = "1.50*Damage (If you can attack)";
	String prize12 = "1.75*Damage (If you can attack)";
	String prize13 = "2.00*Damage (If you can attack)";
	String prize14 = "+50 Attack Point For Next Dice (If you can attack)";
	String prize15 = "+100 Attack Point For Next Dice (If you can attack)";
	private Random randomGenerator;

	public PrizePool() {
		Prizes.add(prize1);
		Prizes.add(prize2);
		Prizes.add(prize3);
		Prizes.add(prize4);
		Prizes.add(prize5);
		Prizes.add(prize6);
		Prizes.add(prize7);
		Prizes.add(prize8);
		Prizes.add(prize9);
		Prizes.add(prize10);
		Prizes.add(prize11);
		Prizes.add(prize12);
		Prizes.add(prize13);
		Prizes.add(prize14);
		Prizes.add(prize15);
		randomGenerator = new Random();
	}

	public void selectPrize (Player p) {
		
		
		 int index = randomGenerator.nextInt(15);
		 String secilen = Prizes.get(index);
		 System.out.println("Congratulations!\n" + "You will get" + secilen + "prize.");
		
		 switch (secilen) {
		 
		 case "+25 HP" :
			//Player1 = prize kazanan oyuncu
			 
			 p.currentHP += 25;
			 System.out.println("You earned 25 HP");
			 System.out.println("Your current HP is " +  p.currentHP);
			
		 break;
		 case "+50 HP" :
			 
			 //Player1 = prize kazanan oyuncu
			 
			 p.currentHP +=50;
			 System.out.println("You earned 50 HP");
			 System.out.println("Your current HP is " +  p.currentHP);
			 break;
		 case "+75 HP" :
			 
			 //Player1 = prize kazanan oyuncu

			 p.currentHP +=75;
			 System.out.println("You earned 75 HP");
			 System.out.println("Your current HP is " + p.currentHP);
		 break;
		 case "+100 HP" :
			 
			 //Player1 = prize kazanan oyuncu

			 p.currentHP +=100;
			 System.out.println("You earned 100 HP");
			 System.out.println("Your current HP is " +  p.currentHP);
		 break;
		 case "Next Dice Shot" :
			 
			 //Player1 = prize kazanan oyuncu
			 //Bu kýsýmda ayarý nasýl yapcaz bilemedim bi el atýn 
			
			 
 case "-25 HP From the Region of Your Choice" :
			 
			 int j=0;
			
			 while(j!=1) {
			System.out.println("Please Enter the Name of the Region your Choose : ");
			 
			String input = keyboardx.nextLine();
			ArrayList<Region> allRegions = new ArrayList<Region>();
			p.setRegions(allRegions);
			for(int i=0; i<allRegions.size() ; i++) 
			{
			
				if(allRegions.get(i).regionName.equals(input)) 
				{
				
					if(!p.currentRegions.contains(allRegions.get(i))) 
					{
						System.out.println("previous hp of " +allRegions.get(i).regionName + "=" +allRegions.get(i).regionHP);
						allRegions.get(i).regionHP -= 25 ;
						System.out.println("new hp of " +allRegions.get(i).regionName + "=" +allRegions.get(i).regionHP);

						j= 1;
							break;
					}
						break; 
					
				}
				
					
				
			}
			if (j==0) {
				System.out.println("Please Enter a Valid Region Name : ");
			}
			 }
			 
			
		 case "-50 HP From the Region of Your Choice" :
			 
			 int k=0;
				
			 while(k!=1) {
			System.out.println("Please Enter the Name of the Region your Choose : ");
			 
			String input = keyboardx.nextLine();
			ArrayList<Region> allRegions = new ArrayList();
			p.setRegions(allRegions);
			for(int i=0; i<allRegions.size() ; i++) {
				if(allRegions.get(i).regionName.equals(input)) {
					System.out.println(p.currentRegions.get(0));
					if(!p.currentRegions.contains(allRegions.get(i))) {
					
						System.out.println("previous hp of " +allRegions.get(i).regionName + "=" +allRegions.get(i).regionHP);
						allRegions.get(i).regionHP -= 50 ;
						System.out.println("new hp of " +allRegions.get(i).regionName + "=" +allRegions.get(i).regionHP);

					k= 1;
					break;
				}
				}
				
					
				
			}
			if (k==0) {
				System.out.println("Please Enter the Correct Name Of the Region: ");
			}
			 }
		 
		 break;
		 case "-75 HP From the Region of Your Choice" :
			 
			 int l=0;
				
			 while(l!=1) {
			System.out.println("Please Enter the Name of the Region your Choose : ");
			 
			String input = keyboardx.nextLine();
			ArrayList<Region> allRegions = new ArrayList();
			p.setRegions(allRegions);
			for(int i=0; i<allRegions.size() ; i++) {
				if(allRegions.get(i).regionName.equals(input)) {
					System.out.println(p.currentRegions.get(0));
					if(!p.currentRegions.contains(allRegions.get(i))) {
						System.out.println("previous hp of " +allRegions.get(i).regionName + "=" +allRegions.get(i).regionHP);
						allRegions.get(i).regionHP -= 75 ;
						System.out.println("new hp of " +allRegions.get(i).regionName + "=" +allRegions.get(i).regionHP);

					l= 1;
					break;
				}
					break; 
				}
				
					
				
			}
			if (l==0) {
				System.out.println("Please Enter the Correct Name Of the Region: ");
			}
			 }
		 
		 break;
		 case "-100 HP From the Region of Your Choice" :
			 int þ=0;
				
			 while(þ!=1) {
			System.out.println("Please Enter the Name of the Region your Choose : ");
			 
			String input = keyboardx.nextLine();
			ArrayList<Region> allRegions = new ArrayList();
			p.setRegions(allRegions);
			for(int i=0; i<allRegions.size() ; i++) {
				System.out.println(p.currentRegions.get(0));
				if(allRegions.get(i).regionName.equals(input)) {
					if(!p.currentRegions.contains(allRegions.get(i))) {
						System.out.println("previous hp of " +allRegions.get(i).regionName + "=" +allRegions.get(i).regionHP);
						allRegions.get(i).regionHP -= 100 ;
						System.out.println("new hp of " +allRegions.get(i).regionName + "=" +allRegions.get(i).regionHP);

					þ= 1;
					break;
				}
					}
				
					
				
			}
			if (þ==0) {
				System.out.println("Please Enter the Correct Name Of the Region: ");
			}
			 }
			 
			 break;
			 
		
		 case "1.25*Damage (If you can attack)" :
			 	p.multiplier=1.25;

			 break;
		 case "1.50*Damage (If you can attack)" :
				p.multiplier=1.50;

			 break;
		 case "1.75*Damage (If you can attack)" :
			 	p.multiplier=1.75;

			 break;
		 case "2.00*Damage (If you can attack)" :
				p.multiplier=2.0;

			 break;
		 case "+50 Attack Point For Next Dice (If you can attack)" :
				p.addition=50;

			break;
		 case "+100 Attack Point For Next Dice (If you can attack)" :
			 	p.addition=100;
			 
			 break;
		 }
		
	}
}
