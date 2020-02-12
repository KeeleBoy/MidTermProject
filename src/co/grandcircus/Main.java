package co.grandcircus;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	/*
	 * @Authors Sam Keim, James McDowell and Kyle Warchuck
	 * 
	 */

	public static void main(String[] args) {

		// Declare variables
		DisplayMethods mm = new DisplayMethods();
		Scanner scnr = new Scanner(System.in);
		boolean userContinue = true;
		int userChoice;
		ArrayList<Media> mediaList = new ArrayList<>();
		mediaList = DVDs.mediaFromFiles();

		// Do-while loop, runs through once and loops until user chooses to exit
		do {
			// Starts by printing menu
			mm.printMenu();
			System.out.println("\nEnter a selection:");

			// Get user selection
			userChoice = Validator.getInt(scnr, 1, 5);
			switch (userChoice) {
			case 1:
				// Display
				DisplayMethods.displayTree(scnr, mediaList);
				break;
			case 2:
				// Search
				DisplayMethods.searchTree(scnr, mediaList);
				break;
			case 3:
				// Sort/Display
				DisplayMethods.sortTree(mediaList, scnr);
				break;
			case 4:
				// Return
				ActionMethods.returnItem(scnr, mediaList);
				break;
			default:
				// Exit
				userContinue = false;
				System.out.println("Thank you for visiting. Goodbye.");
			}
		} while (userContinue);

		ArrayList<Book> books = new ArrayList<>();
		ArrayList<DVD> dvds = new ArrayList<>();

		for (Media media : mediaList) {

			if (media instanceof Book) {

				books.add((Book) media);

			} else if (media instanceof DVD) {

				dvds.add((DVD) media);
			}

		}

		
		
//		DVDs.DVDsToFile(DVDs.getDVDList());
//		Books.BooksToFile(Books.getBookList());
//		DVDs.mediaFromFiles();
		DVDs.fileHelper.rewrite(dvds);
		Books.fileHelper.rewrite(books);
	}
}