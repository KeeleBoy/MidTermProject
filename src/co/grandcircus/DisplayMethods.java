package co.grandcircus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DisplayMethods {

	/*
	 * 
	 * Prints main menu to console
	 * 
	 */
	public void printMenu() {

		System.out.printf("%-40s%-20s%40s\n", "", "+--------------------+", ""); // this is a menu, as indicated by the
																					// method name
		System.out.printf("%-40s%-20s%40s\n", "", "|   UNTOLD STORIES   |", "");
		System.out.printf("%-40s%-20s%40s\n", "+======================================", "|    LIBRARY MENU    |",
				"======================================+");
		System.out.printf("%-40s%-20s%40s\n", "|", "+--------------------+", "|");
		System.out.printf("%-40s%-20s%42s\n", "|", " ", "|");
		System.out.printf("%-40s%-20s%42s\n", "|", "[1]   DISPLAY", "|");
		System.out.printf("%-40s%-20s%42s\n", "|", "[2]   SEARCH", "|");
		System.out.printf("%-40s%-20s%42s\n", "|", "[3]   SORT/DISPLAY", "|");
		System.out.printf("%-40s%-20s%42s\n", "|", "[4]   RETURN ITEM", "|");
		System.out.printf("%-40s%-20s%42s\n", "|", "[5]   DONATE ITEM", "|");
		System.out.printf("%-40s%-20s%42s\n", "|", "[Q]   EXIT", "|");
		System.out.printf("%-40s%-20s%42s\n", "|", "", "|");
		System.out.println(
				"+====================================================================================================+");
	}

	/*
	 * 
	 * Next three methods are tree methods, that display submenus from the main menu
	 * (Above) These methods will fork out based on user input, and dive into action
	 * methods
	 * 
	 */
	public static void displayTree(Scanner scnr, List<Media> library) {
		// submenu selection to display all items of the selected type
		System.out.println("[1] Display Books, [2] Display DVDs, [3] Display AudioBooks, [4] Display All");
		int userChoice = Validator.getInt(scnr, 1, 4);
		int counter = 1;
		List<Media> tempList;
		boolean contloop = true;
		// switch case for selections

		switch (userChoice) {
		case 1:
			// display all books
			tempList = filterByCriteria(library, "", "BOOK");
			break;
		case 2:
			// display all DVDs
			tempList = filterByCriteria(library, "", "DVD");
			break;
		case 3:
			// display all AudioBooks
			tempList = filterByCriteria(library, "", "AUDIOBOOK");
			break;
		default:
			tempList = filterByCriteria(library, "", "ALL");
			// display all
			break;
		}

		// print list of results, prints header only if found
		// Sets counters to 0, when the first item is encountered, it prints the header and then prints the applicable items
		// Relies on the incoming list to be sorted by category in order of BOOKS / DVDS / AUDIOBOOKS
		int bookCounter = 0;
		int dvdCounter = 0;
		int audioBookCounter = 0;

		for (Media m : tempList) {
			if (m instanceof Book) {
				bookCounter++;
				if (bookCounter == 1) {
					System.out.printf("\n%-40s%-20s%40s\n", "+======================================",
							"|        BOOKS       |", "======================================+");
				}
				System.out.println(counter++ + ". " + m);
			} else if (m instanceof DVD) {
				dvdCounter++;
				if (dvdCounter == 1) {
					System.out.printf("\n%-40s%-20s%40s\n", "+======================================",
							"|        DVDS        |", "======================================+");
				}
				System.out.println(counter++ + ". " + m);
			} else if (m instanceof AudioBook) {
				audioBookCounter++;
				if (audioBookCounter == 1) {
					System.out.printf("\n%-40s%-20s%40s\n", "+======================================",
							"|     AUDIOBOOKS     |", "======================================+");
				}
				System.out.println(counter++ + ". " + m);
			}

		}
		while (contloop == true) {
		if (tempList.size() >= 1) {
			// asks user if they want to check out an item
			System.out.println("\n\nWould you like to check out an item? Enter number (\"Q\" to Quit)");
			// If the selection was an integer, proceeds to checkout
			if (scnr.hasNextInt()) {
				int index = Validator.getInt(scnr, 1, tempList.size());
				ActionMethods.checkout(index, scnr, tempList);
			} else {
				String response = scnr.nextLine();
				contloop = Validator.qForQuit(response);
			}
		} else {
			// if there were no items found, print error message
			System.out.println("No items found.");
			contloop = false;
		}
	}
	}

	public static void searchTree(Scanner scnr, List<Media> library) {
		// displays submenu
		System.out.println("Search by [1] Author/Director, [2] Title");
		int userChoice = Validator.getInt(scnr, 1, 2);
		boolean contloop = true;
		int counter = 1;
		boolean exitCondition = false;
		// setup temp list
		List<Media> tempList;
		// switch case for which submenu
		switch (userChoice) {
		case 1:
			// If user selected author/director
			System.out.println("Enter author/director name:");
			String name = scnr.nextLine();
			tempList = DisplayMethods.filterByCriteria(library, name, "NAME");
			break;
		default:
			// If user selected title
			System.out.println("Enter title:");
			String title = scnr.nextLine();
			tempList = DisplayMethods.filterByCriteria(library, title, "TITLE");
		}

		// print list of results
		int bookCounter = 0;
		int dvdCounter = 0;
		int audioBookCounter = 0;

		for (Media m : tempList) {
			if (m instanceof Book) {
				bookCounter++;
				if (bookCounter == 1) {
					System.out.printf("\n%-40s%-20s%40s\n", "+======================================",
							"|        BOOKS       |", "======================================+");
				}
				System.out.println(counter++ + ". " + m);
			} else if (m instanceof DVD) {
				dvdCounter++;
				if (dvdCounter == 1) {
					System.out.printf("\n%-40s%-20s%40s\n", "+======================================",
							"|        DVDS        |", "======================================+");
				}
				System.out.println(counter++ + ". " + m);
			} else if (m instanceof AudioBook) {
				audioBookCounter++;
				if (audioBookCounter == 1) {
					System.out.printf("\n%-40s%-20s%40s\n", "+======================================",
							"|     AUDIOBOOKS     |", "======================================+");
				}
				System.out.println(counter++ + ". " + m);
			}

		}
		
		while (contloop == true) {

		// if there was at least one match
		if (tempList.size() >= 1) {

			// asks user if they want to check out an item
			System.out.println("\n\nWould you like to check out an item? Enter number (\"Q\" to Quit)");
			// If the selection was an integer, proceeds to checkout
			if (scnr.hasNextInt()) {
				int index = Validator.getInt(scnr, 1, tempList.size());
				ActionMethods.checkout(index, scnr, tempList);
			} else {
				String response = scnr.nextLine();
				contloop = Validator.qForQuit(response);
			}
		} else {
			// if there were no items found, print error message
			System.out.println("No items found.");
			contloop = false;
		}
		}
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

	/*
	 * 
	 * Filter list by criteria given, either author, title, dvd, or book
	 * 
	 */

	public static ArrayList<Media> filterByCriteria(List<Media> library, String searchKey, String filterKey) {
		ArrayList<Media> results = new ArrayList<>();
		searchKey = searchKey.toUpperCase();
		switch (filterKey) {
		case "NAME":
			for (Media item : library) {
				// Loops through media items
				if (item instanceof DVD) {
					// If DVD, explicit cast to DVD type and searches using the getDirector method
					DVD dvd = (DVD) item;
					if (dvd.getDirector().toUpperCase().contains(searchKey)) {
						// Stores in temporary array of items
						results.add(dvd);
					}
				} else if (item instanceof Book) {
					// if Book, explicit cast to Book type and searches using the getAuthor method
					Book book = (Book) item;
					if (book.getAuthor().toUpperCase().contains(searchKey)) {
						// Stores in temporary array of items
						results.add(book);
					}

				} else if (item instanceof AudioBook) {
					// if AudioBook, explicit cast to AudioBook type and searches using the
					// getAuthor method
					AudioBook audioBook = (AudioBook) item;
					if (audioBook.getAuthor().toUpperCase().contains(searchKey)) {
						// Stores in temporary array of items
						results.add(audioBook);
					}

				}
			}
			break;
		case "TITLE":
			// Searches by title and displays results
			for (Media m : library) {
				// Loops through looking for match
				if (m.getTitle().toUpperCase().contains(searchKey)) {
					// Adds item to tempList
					results.add(m);
				}
			}
			break;
		case "BOOK":
			// Searches for books only and displays results
			for (Media item : library) {
				if (item instanceof Book) {
					results.add(item);
				}
			}
		case "DVD":
			// Searches for DVDs only and displays results
			for (Media item : library) {
				if (item instanceof DVD) {
					results.add(item);
				}
			}
			break;
		case "AUDIOBOOK":
			// Searches for AudioBook only and displays results
			for (Media item : library) {
				if (item instanceof AudioBook) {
					results.add(item);
				}
			}
			break;
		case "ALL":
			// Adds full library
			results.addAll(library);
		}
		return results;

	}

	/*
	 * 
	 * Next Two Methods - Sort Methods that organize the library by Author or by
	 * Title
	 * 
	 */

	public static ArrayList<Media> sortByTitle(ArrayList<Media> library) {
		// sorts dvds and books together by title
		ArrayList<Book> books = new ArrayList<>(); // creates lists to split the combined list into
		ArrayList<DVD> dvds = new ArrayList<>();
		ArrayList<AudioBook> audioBooks = new ArrayList<>();
		for (Media media : library) {
			if (media instanceof Book) { // splits the books into first list
				books.add((Book) media);
			} else if (media instanceof DVD) { // splits the dvds into the second list
				dvds.add((DVD) media);
			} else if (media instanceof AudioBook) {
				audioBooks.add((AudioBook) media);
			}
		}

		Comparator<Book> compAuthors = (Book o1, Book o2) -> o1.getTitle().compareTo(o2.getTitle()); // creates a
																										// comparator
																										// for books
		Collections.sort(books, compAuthors);// sorts books by comparator
		
		Comparator<AudioBook> compAudioAuthors = (AudioBook o1, AudioBook o2) -> o1.getTitle().compareTo(o2.getTitle()); // creates a
		// comparator
		// for books
		Collections.sort(audioBooks, compAudioAuthors);
		
		Comparator<DVD> compDirector = (DVD o1, DVD o2) -> o1.getTitle().compareTo(o2.getTitle()); // creates a
																											// comparator
																											// for dvds
		Collections.sort(dvds, compDirector); // sorts dvds by comparator

		// Reconstruct into single library
		library.clear();
		library.addAll(books);
		library.addAll(dvds);
		library.addAll(audioBooks);

		return library; // return list // returns an updated list
	}

	public static ArrayList<Media> sortByAuthor(ArrayList<Media> library) {
		// Splits into DVD and Book lists, then sorts by appropriate call method
		// (Director or Author)
		ArrayList<Book> books = new ArrayList<>(); // creates lists to split the combined list into
		ArrayList<DVD> dvds = new ArrayList<>();
		ArrayList<AudioBook> audioBooks = new ArrayList<>();
		for (Media media : library) {
			if (media instanceof Book) { // splits the books into first list
				books.add((Book) media);
			} else if (media instanceof DVD) { // splits the dvds into the second list
				dvds.add((DVD) media);
			} else if (media instanceof AudioBook) {
				audioBooks.add((AudioBook) media);
			}
		}

		Comparator<Book> compAuthors = (Book o1, Book o2) -> o1.getAuthor().compareTo(o2.getAuthor()); // creates a
																										// comparator
																										// for books
		Collections.sort(books, compAuthors);// sorts books by comparator

		Comparator<AudioBook> compAudioAuthors = (AudioBook o1, AudioBook o2) -> o1.getAuthor()
				.compareTo(o2.getAuthor()); // creates a
		// comparator
		// for books
		Collections.sort(audioBooks, compAudioAuthors);

		Comparator<DVD> compDirector = (DVD o1, DVD o2) -> o1.getDirector().compareTo(o2.getDirector()); // creates a
																											// comparator
																											// for dvds
		Collections.sort(dvds, compDirector); // sorts dvds by comparator

		// Reconstruct into single library
		library.clear();
		library.addAll(books);
		library.addAll(dvds);
		library.addAll(audioBooks);

		return library; // return list
	}
}
