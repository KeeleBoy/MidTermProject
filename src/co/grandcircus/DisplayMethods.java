package co.grandcircus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DisplayMethods {
	public static ArrayList<Media> tempList = new ArrayList<>();

	// Prints menu
	public void printMenu() {

		System.out.printf("%-40s%-20s%40s\n", "", "+--------------------+", "");
		System.out.printf("%-40s%-20s%40s\n", "", "|   UNTOLD STORIES   |", "");
		System.out.printf("%-40s%-20s%40s\n", "+======================================", "|    LIBRARY MENU    |",
				"======================================+");
		System.out.printf("%-40s%-20s%40s\n", "|", "+--------------------+", "|");
		System.out.printf("%-40s%-20s%42s\n", "|", " ", "|");
		System.out.printf("%-40s%-20s%42s\n", "|", "[1]   DISPLAY", "|");
		System.out.printf("%-40s%-20s%42s\n", "|", "[2]   SEARCH", "|");
		System.out.printf("%-40s%-20s%42s\n", "|", "[3]   SORT/DISPLAY", "|");
		System.out.printf("%-40s%-20s%42s\n", "|", "[4]   RETURN ITEM", "|");
		System.out.printf("%-40s%-20s%42s\n", "|", "[5]   EXIT", "|");
		System.out.printf("%-40s%-20s%42s\n", "|", "", "|");
		System.out.println("+====================================================================================================+");
	}
	
	public static void sortTree(ArrayList<Media> library, Scanner scnr) {
		// displays submenu
		System.out.println("Sort by [1] Author/Director, [2] Title");
		int userChoice = Validator.getInt(scnr, 1, 2);
		// switch case for which submenu
		switch (userChoice) {
		case 1:
			// author director
			library = sortByAuthor(library);
			DisplayMethods.displayTree(scnr, library);
			break;
		default:
			// title
			library = sortByTitle(library);
			DisplayMethods.displayTree(scnr, library);
		}
		
	}
	
	public static ArrayList<Media> filterByAuthor(String name, List<Media> library) {
		ArrayList<Media> results = new ArrayList<>();
		for (Media item : library) {
			// Loops through media items
			if (item instanceof DVD) {
				// If DVD, explicit cast to DVD type and searches using the getDirector method
				DVD dvd = (DVD) item;
				if (dvd.getDirector().toUpperCase().contains(name)) {
					// Stores in temporary array of items
					results.add(dvd);
				}
			} else {
				// if Book, explicit cast to Book type and searches using the getAuthor method
				Book book = (Book) item;

				// Heres an attempt to only print books that are not checked out

				if (book.getAuthor().toUpperCase().contains(name)) {
					// Stores in temporary array of items
					results.add(book);
				}
			}
		}
		return results;
	}

	// Searches for results by author or director
	public static void displayByAuthor(String name, List<Media> library, Scanner scnr) {
		name = name.toUpperCase(); // to correct inconsistencies in capitalization
		int counter = 1; // Counter for menu of items that match author/director search key
		tempList = filterByAuthor(name, library);

		for (Media item : tempList) {
			System.out.println(counter++ + ". " + item);
		}
		
		// if there was at least one match
		if (tempList.size() >= 1) {
			// asks user if they want to check out an item
			System.out.println("Would you like to check out an item? Enter number (\"Q\" to Quit)");
			// If the selection was an integer, proceeds to checkout
			if (scnr.hasNextInt()) {
				int index = Validator.getInt(scnr, 1, tempList.size());
				scnr.nextLine();
				ActionMethods.checkout(index, scnr, tempList);
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

	public static void displayByTitle(String title, List<Media> library, Scanner scnr) {
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
		if (tempList.size() >= 1) {
			// asks user if they want to check out an item
			System.out.println("Would you like to check out an item? Enter number (\"Q\" to Quit)");
			// If the selection was an integer, proceeds to checkout
			if (scnr.hasNextInt()) {
				int index = Validator.getInt(scnr, 1, tempList.size());
				ActionMethods.checkout(index, scnr, tempList);
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

	public static void displayTree(Scanner scnr, List<Media> library) {
		// submenu selection
		System.out.println("[1] Display Books, [2] Display DVDs, [3] Display All");
		int userChoice = Validator.getInt(scnr, 1, 3);
		int counter = 1;
		// switch case for selections
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
		if (tempList.size() >= 1) {
			// asks user if they want to check out an item
			System.out.println("Would you like to check out an item? Enter number (\"Q\" to Quit)");
			// If the selection was an integer, proceeds to checkout
			if (scnr.hasNextInt()) {
				int index = Validator.getInt(scnr, 1, tempList.size());
				ActionMethods.checkout(index, scnr, tempList);
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
			// If user selected author/director
			System.out.println("Enter author/director name:");
			String name = scnr.nextLine();
			DisplayMethods.displayByAuthor(name, library, scnr);
			break;
		default:
			// If user selected title
			System.out.println("Enter title:");
			String title = scnr.nextLine();
			DisplayMethods.displayByTitle(title, library, scnr);
		}
	}

	public static ArrayList<Media> sortByTitle(List<Media> library) {
		// Sort alphabetically by title, mixes dvds and books together
		Comparator<Media> compareByTitle = (Media o1, Media o2) -> o1.getTitle().compareTo(o2.getTitle());
		Collections.sort(library, compareByTitle);
		return (ArrayList<Media>) library;
	}

	public static ArrayList<Media> sortByAuthor(List<Media> library) {
		// DVDs and books
		// Separates library list into books and into dvds
		ArrayList<Book> books = new ArrayList<>();
		ArrayList<DVD> dvds = new ArrayList<>();
		for (Media media : library) {
			if (media instanceof Book) {
				books.add((Book) media);
			} else if (media instanceof DVD) {
				dvds.add((DVD) media);
			}
		}

		// Create comparators and sort books and DVDs
		Comparator<Book> compAuthors = (Book o1, Book o2) -> o1.getAuthor().compareTo(o2.getAuthor());
		Collections.sort(books, compAuthors);
		Comparator<DVD> compDirector = (DVD o1, DVD o2) -> o1.getDirector().compareTo(o2.getDirector());
		Collections.sort(dvds, compDirector);

		// Reconstruct into single library
		library.clear();
		library.addAll(books);
		library.addAll(dvds);

		return (ArrayList<Media>) library;
	}
}
