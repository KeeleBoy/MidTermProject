package co.grandcircus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Methods {
	public static ArrayList<Media> tempList = new ArrayList<>();
	
	public void printMenu() {
		System.out.println("==================[   LIBRARY MENU   ]==============================");
		System.out.println("\n   [1]   Display");
		System.out.println("   [2]   Search");
		System.out.println("   [3]   Return Item");
		System.out.println("   [4]   Exit\n");
		System.out.println("====================================================================");
	}

	public static void byAuthorDirector(String name, List<Media> library, Scanner scnr) {
		name = name.toUpperCase();
		int counter = 1;
		for (Media item : library) {
			if (item instanceof DVD) {
				DVD dvd = (DVD) item;
				if (dvd.getDirector().toUpperCase().contains(name)) {
					System.out.println(counter++ + ". " + dvd);
					tempList.add(dvd);
				}
			} else {
				Book book = (Book) item;
				if (book.getAuthor().toUpperCase().contains(name)) {
					System.out.println(counter++ + ". " + book);
					tempList.add(book);
				}
			}
		}
		System.out.println("Would you like to check out an item? Enter number (\"Q\" to Quit)");
		if (scnr.hasNextInt()) {
			int index = scnr.nextInt() - 1;
			tempList.get(index);
			System.out.println("Is this correct? (Y/N)");
			boolean userChoice = Validator.yesOrNo(scnr);
			if (userChoice) {
				Methods.checkout(tempList.get(index), scnr);
			}
		}
		scnr.nextLine(); // Clear scanner if q
	}

	public static void byTitle(String title, List<Media> library, Scanner scnr) {
		title = title.toUpperCase();
		int counter = 1;
		for (Media m : library) {
			if (m.getTitle().toUpperCase().contains(title)) {
				System.out.println(counter++ + ". " + m);
				tempList.add(m);
			}
		}
		System.out.println("Would you like to check out an item? Enter number (\"Q\" to Quit)");
		if (scnr.hasNextInt()) {
			int index = scnr.nextInt() - 1;
			tempList.get(index);
			System.out.println("Is this correct? (Y/N)");
			boolean userChoice = Validator.yesOrNo(scnr);
			if (userChoice) {
				Methods.checkout(tempList.get(index), scnr);
			}
		}
		scnr.nextLine(); // Clear scanner
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

	public static void returnItem(Scanner scnr, List<Media> library) {
		Media itemToReturn = library.get(0);
		boolean found = false;
		boolean cannotFind = false;
		System.out.println("Enter title:");
		String title = scnr.nextLine();
		title = title.toUpperCase();
		
		do {
			for (Media item : library) {
				if (item.getTitle().toUpperCase().contains(title)) {
					itemToReturn = item;
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
			int counter = 1;
			for (Media item : library) {
				if (item.isStatus()) {
					System.out.println(counter++ + ". " + item);
					tempList.add(item);
				}
			}
			System.out.println("Enter number:");
			int userChoice = Validator.getInt(scnr, 1, tempList.size());
			tempList.get(userChoice - 1);
			System.out.println("Confirm return (Y/N)");
			found = Validator.yesOrNo(scnr);
			if (found) {
				itemToReturn = tempList.get(userChoice - 1);
			} else {
				System.out.println("Cannot find item to return, please try again.");
			}
		}		
		itemToReturn.setStatus(false);
		System.out.println("You have returned: " + itemToReturn.getTitle());
	}
	
	public static void displayTree(Scanner scnr, List<Media> library) {
		System.out.println("[1] Display Books, [2] Display DVDs, [3] Display All");
		int userChoice = Validator.getInt(scnr, 1, 3);
		int counter = 1;
		switch(userChoice) {
//		case 1:
			//display by creator
			// FIXME Sam sort by author class, mix
//			break;
//		case 2:
			// display by title
			// FIXME Sam Sort by title class, mix together with arrayList master
//			break;
		case 1:
			//display books
			for (Media item : library) {
				if (item instanceof Book) {
					System.out.println(counter++ + ". " + item);
					tempList.add(item);
				}
			}
			break;
		case 2:
			//display DVD
			for (Media item : library) {
				if (item instanceof DVD) {
					System.out.println(counter++ + ". " + item);
					tempList.add(item);
				}
			}
			break;
		default:
			//display all
			for (Media item : library) {
				System.out.println(counter++ + ". " + item);
				tempList.add(item);
			}
			break;
		}
		System.out.println("Would you like to check out an item? Enter number (\"Q\" to Quit)");
		if (scnr.hasNextInt()) {
			int index = scnr.nextInt() - 1;
			tempList.get(index);
			System.out.println("Is this correct? (Y/N)");
			boolean userCheckout = Validator.yesOrNo(scnr);
			if (userCheckout) {
				Methods.checkout(tempList.get(index), scnr);
			}
		}
		scnr.nextLine(); // Clear scanner
	}
	
	public static void searchTree(Scanner scnr, List<Media> library) {
		System.out.println("Search by [1] Author/Director, [2] Title");
		int userChoice = Validator.getInt(scnr, 1, 2);
		switch(userChoice) {
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
