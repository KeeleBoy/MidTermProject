package co.grandcircus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ActionMethods {
	public static void checkout(int index, Scanner scnr, ArrayList<Media> checkoutList) {
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

}
