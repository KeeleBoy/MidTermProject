package co.grandcircus;

import java.util.Scanner;

public class Main {

	/*
	 * @Authors Sam Keim, James McDowell and Kyle Warchuck test
	 * 
	 */

	public static void main(String[] args) {

		Methods mm = new Methods();
		Scanner scnr = new Scanner(System.in);
		boolean userContinue = true;
		int userChoice;

		do {
			mm.printMenu();
			System.out.println("\nEnter a selection:");

			userChoice = Validator.getInt(scnr, 1, 4);
			switch (userChoice) {
			case 1:
				// Display
				break;
			case 2:
				// Search
				break;
			case 3:
				// Return
				break;
			default:
				userContinue = false;
				System.out.println("Thank you for visiting. Goodybe.");
			}
		} while (userContinue);

	}
}
