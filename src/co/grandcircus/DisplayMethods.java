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
		System.out.printf("%-40s%-20s%42s\n", "|", "[6]   EXIT", "|");
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
		// print list of results
		for (Media m : tempList) {
			System.out.println(counter++ + ". " + m);
		}
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
	}

	public static void searchTree(Scanner scnr, List<Media> library) {
		// displays submenu
		System.out.println("Search by [1] Author/Director, [2] Title");
		int userChoice = Validator.getInt(scnr, 1, 2);
		int counter = 1;
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
		for (Media m : tempList) {
			System.out.println(counter++ + ". " + m);
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
				} else if (item instanceof Book){
					// if Book, explicit cast to Book type and searches using the getAuthor method
					Book book = (Book) item;
					if (book.getAuthor().toUpperCase().contains(searchKey)) {
						// Stores in temporary array of items
						results.add(book);
					} 
				
				} else if (item instanceof AudioBook) {
						// if AudioBook, explicit cast to AudioBook type and searches using the getAuthor method
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
		}return results;

	}

	public static ArrayList<Media> donation(Scanner scnr, ArrayList<Media> library) {

		String donationType = Validator.getString(scnr, "What would you like to donate? (DVD, Book or AudioBook)");
		// asks what the person wants to donate
		DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yy"); // sets up a starting date that will never be
																			// seen since Java doesn't like null
		String dueDate = "3/1/20";
		LocalDate setDueDate = LocalDate.parse(dueDate, format);

		if (donationType.equalsIgnoreCase("dvd")) { // if they donate dvds
			String title = Validator.getString(scnr, "What is the name of the DVD?");// sets up the variables to create
																						// the dvd
			String director = Validator.getString(scnr, "Who directed " + title + "?");
			System.out.println("How long is the " + title + "?");
			int runtime = Validator.getInt(scnr);

			DVD dvd1 = new DVD(title, false, setDueDate, runtime, director); // creates the dvd
			library.add(dvd1); // adds the dvd to the list being returned

			return library;
		} else if (donationType.equalsIgnoreCase("Book")) { // if they donate a book

			String title = Validator.getString(scnr, "What is the name of the book?"); // sets up the variables to
																						// create the book
			String author = Validator.getString(scnr, "Who wrote " + title + "?");

			Book book1 = new Book(title, false, setDueDate, author); // creates the book

			library.add(book1); // adds the book to the list being returned

			return library;
		} else if (donationType.equalsIgnoreCase("AudioBook")) {
			String title = Validator.getString(scnr, "What is the name of the AudioBook?");// sets up the variables to
																							// create
			// the audioBook
			String author = Validator.getString(scnr, "Who wrote " + title + "?");
			System.out.println("How long is the " + title + "?");
			int runtime = Validator.getInt(scnr);

			AudioBook audioBook1 = new AudioBook(title, false, runtime, author); // creates the audioBook
			library.add(audioBook1); // adds the audiBook to the list being returned

			return library;
		} else {
			System.out.println("We do not return that kind of media."); // if they try to donate a fork (or literally
																		// anything except a book or dvd)
			return library; // returns an unchanged library
		}
	}
	/*
	 * 
	 * Next Two Methods - Sort Methods that organize the library by Author or by
	 * Title
	 * 
	 */

	public static ArrayList<Media> sortByTitle(ArrayList<Media> library) {
		// sorts dvds and books together by title
		Comparator<Media> compareByTitle = (Media o1, Media o2) -> o1.getTitle().compareTo(o2.getTitle()); // creates a
																											// comparator
																											// to sort
																											// with
		Collections.sort(library, compareByTitle); // sorts using the comparator
		return library; // returns an updated list
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
		
		Comparator<AudioBook> compAudioAuthors = (AudioBook o1, AudioBook o2) -> o1.getAuthor().compareTo(o2.getAuthor()); // creates a
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
