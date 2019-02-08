package dev.kaan.game.mainCodes;

import java.util.ArrayList;
import java.util.Random;

public class Achievements  {

	ArrayList<String> GoalsOfRank1 = new ArrayList<String>();
	ArrayList<String> GoalsOfRank2 = new ArrayList<String>();
	ArrayList<String> GoalsOfRank3 = new ArrayList<String>();
	ArrayList<String> GoalsOfRank4 = new ArrayList<String>();
	ArrayList<String> GoalsOfRank5 = new ArrayList<String>();

	String goal1 = "Conquer 1 Neighboring Areas";
	String goal2 = "Give 100+ damage point in one attack";
	String goal3 = "Attack Any Region";

	String goal4 = "Conquer 2 Neighboring Areas";
	String goal5 = "Give 200+ damage point in one attack";
	String goal6 = "Reach total 17+ regions";

	String goal7 = "Conquer 3 Neighboring Areas";
	String goal8 = "Give 300+ damage point in one attack";
	String goal9 = "Reach total 22+ regions";

	String goal10 = "Conquer 4 Neighboring Areas";
	String goal11 = "Give 400+ damage point in one attack";
	String goal12 = "Reach total 30+ regions";

	String goal13 = "Take Over the Opponent's Capital";
	String goal14 = "Give 500 damage point in one attack";
	String goal15 = "Reach total 40+ regions";

	public Achievements() {


		GoalsOfRank1.add(goal1);
		GoalsOfRank1.add(goal2);
		GoalsOfRank1.add(goal3);

		GoalsOfRank2.add(goal4);
		GoalsOfRank2.add(goal5);
		GoalsOfRank2.add(goal6);

		GoalsOfRank3.add(goal7);
		GoalsOfRank3.add(goal8);
		GoalsOfRank3.add(goal9);

		GoalsOfRank4.add(goal10);
		GoalsOfRank4.add(goal11);
		GoalsOfRank4.add(goal12);

		GoalsOfRank5.add(goal13);
		GoalsOfRank5.add(goal14);
		GoalsOfRank5.add(goal15);

	}

	public void newAchievements(Rank rank) {
		if (rank.getRankName().equals("Corporal")) {
			System.out.println("Your Achievements Are:\n");
			for (int j = 0; j < GoalsOfRank1.size(); j++) {
				System.out.println("* " + j + ") " + GoalsOfRank1.get(j) + "\n");
			}
		} else if (rank.getRankName().equals("Sergeant")) {
			System.out.println("Your Achievements Are:\n");
			for (int j = 0; j < GoalsOfRank2.size(); j++) {
				System.out.println("* " + j + ") " + GoalsOfRank2.get(j) + "\n");
			}
		} else if (rank.getRankName().equals("Lieutenant")) {
			System.out.println("Your Achievements Are:\n");
			for (int j = 0; j < GoalsOfRank3.size(); j++) {
				System.out.println("* " + j + ") " + GoalsOfRank3.get(j) + "\n");
			}
		}
		if (rank.getRankName().equals("Captain")) {
			System.out.println("Your Achievements Are:\n");
			for (int j = 0; j < GoalsOfRank4.size(); j++) {
				System.out.println("* " + j + ") " + GoalsOfRank4.get(j) + "\n");
			}
		}
		if (rank.getRankName().equals("Major")) {
			System.out.println("Your Achievements Are:\n");
			for (int j = 0; j < GoalsOfRank5.size(); j++) {
				System.out.println("* " + j + ") " + GoalsOfRank5.get(j) + "\n");
			}
		}
	}

	public void completeAchieve(Rank rank , Player player) {

		// Rank1 Görev Kontrol Kýsmý
		if (rank.getRankName().equals("Corporal")) {

			// Player1 = sýrasý gelen oyuncu
			// Player2 = Saldýrýlan oyuncu

			if (rank.checkers.get(0) == 1 && rank.checkers.get(1) == 1 && rank.checkers.get(2) == 1) {
				// Player1.rankUp();
				
				System.out.println("Congratulations! You achieve all the achievements for this rank.\n");
				for (int i = 0; i < rank.checkers.size(); i++) {
					rank.checkers.set(i, 0);
				}
				rank.rankUp(player);
				System.out.println("Welcome to Rank2! There are Your Achievements:\n");
				for (int ç = 0; ç < GoalsOfRank2.size(); ç++) {
					System.out.println("* " + ç + ") " + GoalsOfRank2.get(ç) + "\n");
				}

				rank.getPrizepool(player);

			} else {
				
				System.out.println("You have not completed all achievements");
			}
		}
		// Rank2 Görev Kontrol Kýsmý
		else if (rank.getRankName().equals("Sergeant")) {

			if (rank.checkers.get(0) == 2 && rank.checkers.get(1) == 1 && rank.checkers.get(2) == 1) {
				
				rank.rankUp(player);
				for (int i = 0; i < rank.checkers.size(); i++) {
					rank.checkers.set(i, 0);
				}

				System.out.println("Congratulations! You achieve all the achievements for this rank.\n");
				System.out.println("Welcome to Rank3! There are Your Achievements:\n");
				for (int k = 0; k < GoalsOfRank3.size(); k++) {
					System.out.println("* " + k + ") " + GoalsOfRank3.get(k) + "\n");
				}
				rank.getPrizepool(player);

			} else {
				
				System.out.println("You have not completed all achievements");
			}
		}
		// Rank3 Görev Kontrol Kýsmý
		else if (rank.getRankName().equals("Lieutenant")) {

			// Player1 = sýrasý gelen oyuncu
			// Player2 = Saldýrýlan oyuncu

			if (rank.checkers.get(0) == 3 && rank.checkers.get(1) == 1 && rank.checkers.get(2) == 1) {
				
				for (int i = 0; i < rank.checkers.size(); i++) {
					rank.checkers.set(i, 0);
				}

				rank.rankUp(player);

				System.out.println("Congratulations! You achieve all the achievements for this rank.\n");
				System.out.println("Welcome to Rank4! There are Your Achievements:\n");
				for (int k = 0; k < GoalsOfRank4.size(); k++) {
					System.out.println("* " + k + ") " + GoalsOfRank4.get(k) + "\n");
				}
				rank.getPrizepool(player);

			} else {
				
				System.out.println("You have not completed all achievements");
			}
		}
		// Rank4 Görev Kontrol Kýsmý
		else if (rank.getRankName().equals("Captain")) {

			if (rank.checkers.get(0) == 4 && rank.checkers.get(1) == 1 && rank.checkers.get(2) == 1) {

				Rank maj = new Rank("Major");
				rank.rankUp(player);
				for (int i = 0; i < 3; i++) {
					rank.checkers.remove(0);
				}

				System.out.println("Congratulations! You achieve all the achievements for this rank.\n");
				System.out.println("Welcome to Rank5! There are Your Achievements:\n");
				for (int k = 0; k < GoalsOfRank5.size(); k++) {
					System.out.println("* " + k + ") " + GoalsOfRank5.get(k) + "\n");
				}
				rank.getPrizepool(player);

			} else {
				
				System.out.println("You have not completed all achievements");
			}
		}
		// Rank5 Görev Kontrol Kýsmý
		else if (rank.getRankName().equals("Major")) {

			if (rank.checkers.get(0) == 1 && rank.checkers.get(1) == 1 && rank.checkers.get(2) == 1) {

				System.out.println("Congratulations! You achieve all the achievements for this game.");
				rank.getPrizepool(player);
			}
			else {
				
				System.out.println("You have not completed all achievements");
			}

		} 
	}

	public void getPrize(Rank rank , Player player) {

		rank.getPrizepool(player);
	}
}
