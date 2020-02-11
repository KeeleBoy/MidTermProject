package co.grandcircus;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Methods {

	public void printMenu() {
		System.out.println("==================[   LIBRARY MENU   ]==============================");
		System.out.println("\n   [1]   Display");
		System.out.println("   [2]   Search");
		System.out.println("   [3]   Return Item");
		System.out.println("   [4]   Exit\n");
		System.out.println("====================================================================");

	}

	public static void byAuthorDirector(String name, List<Book> bookLibrary, List<DVD> DVDLibrary) {
		name = name.toUpperCase();
		for (DVD m : DVDLibrary) {
			if (m.getDirector().toUpperCase().contains(name)) {
				System.out.println(m);
			}
		}
		for (Book m : bookLibrary) {
			if (m.getAuthor().toUpperCase().contains(name)) {
				System.out.println(m);
			}
		}
	}

	public static void byTitle(String title, List<Book> bookLibrary, List<DVD> DVDLibrary) {
		title = title.toUpperCase();
		for (Media m : bookLibrary) {
			if (m.getTitle().toUpperCase().contains(title)) {
				System.out.println(m);
			}
		}
		for (Media m : DVDLibrary) {
			if (m.getTitle().toUpperCase().contains(title)) {
				System.out.println(m);
			}
		}
	}

	public static void checkout(Media media, Scanner scnr) {
		System.out.println(media);
		LocalDate dueDate = media.getDueDate().plusDays(14);
		System.out.println("Due Date: " + dueDate.toString());
		System.out.println("Confirm Checkout (Y/N):");
		boolean confirm = Validator.yesOrNo(scnr);
		if (confirm) {
			media.setDueDate(dueDate);
		}
		System.out.printf("Please return %s by %s", media.getTitle(), media.getDueDate());

	}

	public static void displayTree(Scanner scnr, List<Book> bookLibrary, List<DVD> DVDLibrary) {
		System.out.println("[1] Display by Author/Director, [2] Display by Title, [3] Display Books, [4] Display DVDs, [5] Display All");
		int userChoice = Validator.getInt(scnr, 1, 5);
		switch(userChoice) {
		case 1:
			//display by creator
			System.out.println("Enter author/director name:");
			String name = scnr.nextLine();
			Methods.byAuthorDirector(name, bookLibrary, DVDLibrary);
			break;
		case 2:
			// display by title
			System.out.println("Enter title:");
			String title = scnr.nextLine();
			Methods.byTitle(title, bookLibrary, DVDLibrary);
			break;
		case 3:
			//display books
			for (Book b : bookLibrary) {
				System.out.println(b);
			}
			break;
		case 4:
			//display DVD
			for (DVD dvd : DVDLibrary) {
				System.out.println(dvd);
			}
			break;
		default:
			//display all
			for (Book b : bookLibrary) {
				System.out.println(b);
			}
			for (DVD dvd : DVDLibrary) {
				System.out.println(dvd);
			}
			break;
		}
		
	}
}
