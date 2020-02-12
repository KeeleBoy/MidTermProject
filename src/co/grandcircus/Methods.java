package co.grandcircus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Methods {
	public static ArrayList<Media> tempList = new ArrayList<>();

	// Prints menu
	public void printMenu() {
		System.out.println("==================[   LIBRARY MENU   ]==============================");
		System.out.println("\n   [1]   Display");
		System.out.println("   [2]   Search");
		System.out.println("   [3]   Return Item");
		System.out.println("   [4]   Exit\n");
		System.out.println("====================================================================");
	}

	// Searches for results by author or director
	public static void byAuthorDirector(String name, List<Media> library, Scanner scnr) {
		name = name.toUpperCase(); // to correct inconsistencies in capitalization
		int counter = 1; // Counter for menu of items that match author/director search key
		for (Media item : library) {
			// Loops through media items
			if (item instanceof DVD) {
				// If DVD, explicit cast to DVD type and searches using the getDirector method
				DVD dvd = (DVD) item;
				if (dvd.getDirector().toUpperCase().contains(name)) {
					System.out.println(counter++ + ". " + dvd);
					// Stores in temporary array of items
					tempList.add(dvd);
				}
			} else {
				// if Book, explicit cast to Book type and searches using the getAuthor method
				Book book = (Book) item;
				if (book.getAuthor().toUpperCase().contains(name)) {
					System.out.println(counter++ + ". " + book);
					// Stores in temporary array of items
					tempList.add(book);
				}
			}
		}
		// if there was at least one match
		if (tempList.size() > 1) {
			// asks user if they want to check out an item
			System.out.println("Would you like to check out an item? Enter number (\"Q\" to Quit)");
			// If the selection was an integer, proceeds to checkout
			if (scnr.hasNextInt()) {
				int index = Validator.getInt(scnr, 1, tempList.size());
				scnr.nextLine();
				Methods.checkout(index, scnr);
			} else {
				// if not, assumes user wants to quit, clears scanner, and exits
				scnr.nextLine();
			}
		} else {
			// if there were no items found, print error message
			System.out.println("No items found.");
		}
		tempList.clear(); // clears for next method
	}

	public static void byTitle(String title, List<Media> library, Scanner scnr) {
		// Searches by title and displays results
		title = title.toUpperCase(); // to correct inconsistencies in capitalization
		int counter = 1; // Counter for items to be displayed
		for (Media m : library) {
			// Loops through looking for match
			if (m.getTitle().toUpperCase().contains(title)) {
				System.out.println(counter++ + ". " + m);
				// Adds item to tempList
				tempList.add(m);
			}
		}
		// if there was at least one match
		if (tempList.size() > 1) {
			// asks user if they want to check out an item
			System.out.println("Would you like to check out an item? Enter number (\"Q\" to Quit)");
			// If the selection was an integer, proceeds to checkout
			if (scnr.hasNextInt()) {
				int index = Validator.getInt(scnr, 1, tempList.size());
				scnr.nextLine();
				Methods.checkout(index, scnr);
			} else {
				// if not, assumes user wants to quit, clears scanner, and exits
				scnr.nextLine();
			}
		} else {
			// if there were no items found, print error message
			System.out.println("No items found.");
		}
		tempList.clear(); // clears for next method
	}

	public static void checkout(int index, Scanner scnr) {
		// decrement index to match 0,1,2 indexing
		index--;
		// prints item to check out
		System.out.println(tempList.get(index));
		System.out.println("Is this correct? (Y/N)");
		boolean userChoice = Validator.yesOrNo(scnr);
		// If they want to check out the item
		if (userChoice) {
			// assigns to variable
			Media itemToCheckout = tempList.get(index);
			// calculates due date
			LocalDate dueDate = LocalDate.now().plusDays(14);
			System.out.println("Due Date: " + dueDate.toString());
			System.out.println("Confirm Checkout (Y/N):");
			boolean confirm = Validator.yesOrNo(scnr);
			// if user agrees to due date
			if (confirm) {
				itemToCheckout.setDueDate(dueDate);
				itemToCheckout.setStatus(true);
			}
			// prints reminder message
			System.out.printf("Please return %s by %s\n\n", itemToCheckout.getTitle(), itemToCheckout.getDueDate());
		}
	}

	public static void returnItem(Scanner scnr, List<Media> library) {
		// sets variables
		Media itemToReturn = library.get(0);
		boolean found = false;
		boolean cannotFind = false;
		// gets user input
		System.out.println("Enter title:");
		String title = scnr.nextLine();
		title = title.toUpperCase(); // to correct inconsistencies in capitalization

		// searches first by title
		do {
			for (Media item : library) {
				if (item.getTitle().toUpperCase().contains(title)) {
					itemToReturn = item;
					found = true;
				}
			}
			cannotFind = true;
		} while (!found || !cannotFind);

		// if the searcher found an item, prints item and asks if correct
		if (found) {
			System.out.println(itemToReturn);
			System.out.println("Is this the correct item? (Y/N)");
			found = Validator.yesOrNo(scnr);
		}

		// if the searcher could not find a match and the user has rejected a proposed
		// match
		if (cannotFind && !found) {
			// prints checked-out items
			int counter = 1;
			for (Media item : library) {
				if (item.isStatus()) {
					System.out.println(counter++ + ". " + item);
					tempList.add(item);
				}
			}
			// asks for user input to select item to return
			System.out.println("Enter number:");
			int userChoice = Validator.getInt(scnr, 1, tempList.size());
			tempList.get(userChoice - 1);
			// confirms
			System.out.println("Confirm return (Y/N)");
			found = Validator.yesOrNo(scnr);
			// prints item
			if (found) {
				itemToReturn = tempList.get(userChoice - 1);
			} else {
				System.out.println("Cannot find item to return, please try again.");
			}
		}
		// returns item
		itemToReturn.setStatus(false);
		System.out.println("You have returned: " + itemToReturn.getTitle());
		tempList.clear(); // Clear list for next method
	}

	public static void displayTree(Scanner scnr, List<Media> library) {
		// submenu selection
		System.out.println("[1] Display Books, [2] Display DVDs, [3] Display All");
		int userChoice = Validator.getInt(scnr, 1, 3);
		int counter = 1;
		// switch case for selections, should break this up into multiple methods FIXME
		// Sam
		switch (userChoice) {
//		case 1:
		// display by creator
		// FIXME Sam sort by author class, mix
//			break;
//		case 2:
		// display by title
		// FIXME Sam Sort by title class, mix together with arrayList master
//			break;
		case 1:
			// display books
			for (Media item : library) {
				if (item instanceof Book) {
					System.out.println(counter++ + ". " + item);
					tempList.add(item);
				}
			}
			break;
		case 2:
			// display DVD
			for (Media item : library) {
				if (item instanceof DVD) {
					System.out.println(counter++ + ". " + item);
					tempList.add(item);
				}
			}
			break;
		default:
			// display all
			for (Media item : library) {
				System.out.println(counter++ + ". " + item);
				tempList.add(item);
			}
			break;
		}
		// if there was at least one match
		if (tempList.size() > 1) {
			// asks user if they want to check out an item
			System.out.println("Would you like to check out an item? Enter number (\"Q\" to Quit)");
			// If the selection was an integer, proceeds to checkout
			if (scnr.hasNextInt()) {
				int index = Validator.getInt(scnr, 1, tempList.size());
				Methods.checkout(index, scnr);
			} else {
				// if not, assumes user wants to quit, clears scanner, and exits
				scnr.nextLine();
			}
		} else {
			// if there were no items found, print error message
			System.out.println("No items found.");
		}
		tempList.clear(); // clears for next method
	}


	public static void searchTree(Scanner scnr, List<Media> library) {
		// displays submenu
		System.out.println("Search by [1] Author/Director, [2] Title");
		int userChoice = Validator.getInt(scnr, 1, 2);
		// switch case for which submenu
		switch (userChoice) {
		case 1:
			// author director
			System.out.println("Enter author/director name:");
			String name = scnr.nextLine();
			Methods.byAuthorDirector(name, library, scnr);
			break;
		default:
			// title
			System.out.println("Enter title:");
			String title = scnr.nextLine();
			Methods.byTitle(title, library, scnr);
		}
	}
}
