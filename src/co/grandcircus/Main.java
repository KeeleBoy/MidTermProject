package co.grandcircus;

import java.util.ArrayList;
import java.util.List;
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
			
			ArrayList<DVD> DVDLibrary = new ArrayList<>();
			DVDLibrary = DVDs.getDVDList();
			
			ArrayList<Book> bookLibrary = new ArrayList<>();
			bookLibrary = Books.getBookList();
					
			userChoice = Validator.getInt(scnr, 1, 4);
			switch (userChoice) {
			case 1:
				// Display
				Methods.displayTree(scnr, bookLibrary, DVDLibrary);
				break;
			case 2:
				// Search
				Methods.searchTree(scnr, bookLibrary, DVDLibrary);
				break;
			case 3:
				// Return
				Methods.returnItem(scnr, bookLibrary, DVDLibrary);
				break;
			default:
				userContinue = false;
				System.out.println("Thank you for visiting. Goodybe.");
			}
		} while (userContinue);

	}
}
