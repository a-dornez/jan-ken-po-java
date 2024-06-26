/*
 * Name: Jan Ken Po
 * Author: a-dornez <https://github.com/a-dornez>
 * Version: 1.0
 * Copyright: MIT license
 * Description: Terminal based Jan Ken Po game! User plays against a machine player, whose plays
 * are randomly decided, player can choose to play again. A simple way to exercise and assess my
 * skills, practice designing and considering multiple ways to approach problems.
 */

import java.util.Random;
import java.util.Scanner;

public class JanKenPo {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int wins = 0;
		int losses = 0;
		int draws= 0;
		
		String playAgain;
		do {
			//player play
			System.out.print("\nChoose your hand: R-rock, S-scissor, P-paper: ");
			String playerHand = scanner.nextLine();
			
			//pc Play
			String[] possibleHands = new String[] {"R", "S", "P"};
			Random getPcHand = new Random();
			int chosenHandIndex = getPcHand.nextInt(possibleHands.length);
			String pcHand = possibleHands[chosenHandIndex];
			
			//player hand vs pc hand - uses human-player victory scenarios as perspective
			String winLose;
			if ( playerHand.equalsIgnoreCase("R") && pcHand == "S" ) {
				winLose = "Win";
				wins++;
			} else if ( playerHand.equalsIgnoreCase("S") && pcHand == "P" ) {
				winLose = "Win";
				wins++;
			} else if ( playerHand.equalsIgnoreCase("P") && pcHand == "R" ) {
				winLose = "Win";
				wins++;
			} else if ( playerHand.equalsIgnoreCase(pcHand) ) {
				winLose = "Draw";
				draws++;
			} else {
				winLose = "Lose";
				losses++;
			}
			
			System.out.println("\nYour Hand " + playerHand.toUpperCase() + " Vs Pc Hand " + pcHand);
			System.out.println("\n" + winLose + "!\n");
			
			System.out.print("Do you want to play again?(y/n): ");
			playAgain = scanner.nextLine();
			
			//Score board
			int roundsQuantity = 0;
			roundsQuantity++;
			if (roundsQuantity > 0) {
				System.out.println("\nScore: Wins - " + wins + ", Draws - " + draws + ", Losses - " + losses);
			}
			
		} while (playAgain.equalsIgnoreCase("Y") );
		
		scanner.close();
	}
}

