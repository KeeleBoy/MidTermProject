package co.grandcircus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ActionMethods {
	public static void checkout(int index, Scanner scnr, List<Media> checkoutList) {
		// decrement index to match 0,1,2 indexing
		index--;
		if (!checkoutList.get(index).isCheckedOut()) {
			// prints item to check out
			System.out.println(checkoutList.get(index));
			System.out.println("Is this correct? (Y/N)");
			boolean userChoice = Validator.yesOrNo(scnr);
			// If they want to check out the item
			if (userChoice) {
				// assigns to variable
				Media itemToCheckout = checkoutList.get(index);
				// calculates due date
				LocalDate dueDate = LocalDate.now().plusDays(14);
				System.out.println("Due Date: " + dueDate.toString());
				System.out.println("Confirm Checkout (Y/N):");
				boolean confirm = Validator.yesOrNo(scnr);
				// if user agrees to due date
				if (confirm) {
					itemToCheckout.setDueDate(dueDate);
					itemToCheckout.setCheckedOut(true);
				}
				// prints reminder message
				System.out.printf("Please return %s by %s\n\n", itemToCheckout.getTitle(), itemToCheckout.getDueDate());
			}
		} else {
			System.out.println("That item is not available.");
		}
	}

	public static void returnItem(Scanner scnr, List<Media> library) {
		ArrayList<Media> tempList = new ArrayList<>();
		// sets variables
		Media itemToReturn = library.get(0);
		boolean found = false;
		int counter = 1;

		for (Media item : library) {
			if (item.isCheckedOut()) {
				System.out.println(counter++ + ". " + item);
				tempList.add(item);
			}
		}

		while (tempList.size() > 0) {

			System.out.println("Here are some checked out items.");

			// asks for user input to select item to return
			System.out.println("Which item would you like to return? Enter number (\"Q\" to Quit)");
			if (scnr.hasNextInt()) {
				int userChoice = Validator.getInt(scnr, 1, tempList.size());
				tempList.get(userChoice - 1);
				// confirms
				System.out.println("Confirm return (Y/N)");
				found = Validator.yesOrNo(scnr);
				// prints item
				if (found) {
					itemToReturn = tempList.get(userChoice - 1);
					itemToReturn.setCheckedOut(false);
					System.out.println("You have returned: " + itemToReturn.getTitle());
				} else {
					System.out.println(
							"Remember " + itemToReturn.getTitle() + " is due back on " + itemToReturn.getDueDate());
				}
			} else {
				// if not, assumes user wants to quit, clears scanner, and exits
				scnr.nextLine();
			}
			// returns item
			tempList.clear(); // Clear list for next method
		}
	}

	public static ArrayList<Media> donation(Scanner scnr, ArrayList<Media> library) {

		System.out.println("What would you like to donate? [1] Book [2] DVD [3] Audiobook");
		int donationType = Validator.getInt(scnr, 1, 3); // asks what the person wants to donate

		DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yy"); // sets up a starting date that will never be
																			// seen since Java doesn't like null
		String dueDate = "3/1/20"; // Default date
		LocalDate setDueDate = LocalDate.parse(dueDate, format); // Converts to LocalDate

		if (donationType == 1) { // if they donate a book

			String title = Validator.getString(scnr, "What is the name of the book?\n"); // sets up the variables to
																						// create the book
			String author = Validator.getString(scnr, "Who wrote " + title + "?\n");

			Book book1 = new Book(title, false, setDueDate, author); // creates the book

			library.add(book1); // adds the book to the list being returned

			return library;
		} else if (donationType == 2) { // if they donate dvds
			String title = Validator.getString(scnr, "What is the name of the DVD?\n");// sets up the variables to create
																						// the dvd
			String director = Validator.getString(scnr, "Who directed " + title + "?\n");
			System.out.println("How long is the " + title + "?\n");
			int runtime = Validator.getInt(scnr);

			DVD dvd1 = new DVD(title, false, setDueDate, runtime, director); // creates the dvd
			library.add(dvd1); // adds the dvd to the list being returned			
		} else if (donationType == 3) { // if they donate an audiobook

			String title = Validator.getString(scnr, "What is the name of the book?\n"); // sets up the variables to
																						// create the book
			String author = Validator.getString(scnr, "Who wrote " + title + "?\n");

			Book book1 = new Book(title, false, setDueDate, author); // creates the book

			library.add(book1); // adds the book to the list being returned
		} else {
			System.out.println("We do not accept that type of media."); // if they try to donate a fork (or literally
																		// anything except a book or dvd)
		}
		return library;
	}

}
