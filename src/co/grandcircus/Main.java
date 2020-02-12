package co.grandcircus;

import java.util.ArrayList;
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
			
			ArrayList<Media> mediaList = new ArrayList<>();
			mediaList = DVDs.mediaFromFiles();
					
			userChoice = Validator.getInt(scnr, 1, 4);
			switch (userChoice) {
			case 1:
				// Display
				Methods.displayTree(scnr, mediaList);
				break;
			case 2:
				// Search
				Methods.searchTree(scnr, mediaList);
				break;
			case 3:
				// Return
				Methods.returnItem(scnr, mediaList);
				break;
			default:
				userContinue = false;
				System.out.println("Thank you for visiting. Goodybe.");
			}
		} while (userContinue);
		
	}
}
