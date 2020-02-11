package co.grandcircus;

import java.time.LocalDate;
import java.util.ArrayList;
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

	public static void returnItem(Scanner scnr, List<Book> bookLibrary, List<DVD> DVDLibrary) {
		Media itemToReturn = bookLibrary.get(0);
		boolean found = false;
		boolean cannotFind = false;
		System.out.println("Enter title:");
		String title = scnr.nextLine();
		title = title.toUpperCase();
		
		do {
			for (Book b : bookLibrary) {
				if (b.getTitle().toUpperCase().contains(title)) {
					itemToReturn = b;
					found = true;
				}
			}
			for (DVD d : DVDLibrary) {
				if (d.getTitle().toUpperCase().contains(title)) {
					itemToReturn = d;
					found = true;
				}
			}
			cannotFind = true;
		} while (!found || !cannotFind);
		if (found) {
			System.out.println(itemToReturn);
			System.out.println("Is this the correct item? (Y/N)");
			found = Validator.yesOrNo(scnr);
		}
		if (cannotFind && !found) {
			List<Media> checkedOut = new ArrayList<>();
			int counter = 1;
			for (Book b : bookLibrary) {
				if (b.isStatus()) {
					System.out.println(counter++ + ". " + b);
					checkedOut.add(b);
				}
			}
			for (DVD d : DVDLibrary) {
				if (d.isStatus()) {
					System.out.println(counter++ + ". " + d);
					checkedOut.add(d);
				}
			}
			System.out.println("Enter number:");
			int userChoice = Validator.getInt(scnr, 1, checkedOut.size());
			checkedOut.get(userChoice - 1);
			System.out.println("Confirm return (Y/N)");
			found = Validator.yesOrNo(scnr);
			if (found) {
				itemToReturn = checkedOut.get(userChoice - 1);
			} else {
				System.out.println("Cannot find item to return, please try again.");
				break;
			}
			itemToReturn.setStatus(false);
			System.out.println("You have returned: " + itemToReturn);
		}		
	}
	public static void displayTree(Scanner scnr, List<Book> bookLibrary, List<DVD> DVDLibrary) {
		System.out.println("[1] Sort by Author/Director, [2] Sort by Title, [3] Display Books, [4] Display DVDs, [5] Display All");
		int userChoice = Validator.getInt(scnr, 1, 5);
		switch(userChoice) {
		case 1:
			//display by creator
			// FIXME Sam sort by author class, mix
			break;
		case 2:
			// display by title
			// FIXME Sam Sort by title class, mix together with arrayList master
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
	
	public static void searchTree(Scanner scnr, List<Book> bookLibrary, List<DVD> DVDLibrary) {
		System.out.println("Search by [1] Author/Director, [2] Title");
		int userChoice = Validator.getInt(scnr, 1, 2);
		switch(userChoice) {
		case 1:
			// author director
			System.out.println("Enter author/director name:");
			String name = scnr.nextLine();
			Methods.byAuthorDirector(name, bookLibrary, DVDLibrary);
		default:
			// title
			System.out.println("Enter title:");
			String title = scnr.nextLine();
			Methods.byTitle(title, bookLibrary, DVDLibrary);
		}
	}
}
