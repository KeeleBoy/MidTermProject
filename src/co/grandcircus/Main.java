package co.grandcircus;

import java.util.Scanner;

public class Main {

	/*
	 * @Authors Sam Keim, James McDowell and Kyle Warchuck test
	 * 
	 */

	public static void main(String[] args) {
<<<<<<< HEAD
	

=======
		Methods mm = new Methods();
		Scanner scnr = new Scanner(System.in);
		boolean userContinue = true;
		int userChoice;
		
		do{
			mm.printMenu();
			System.out.println("\nEnter a selection:");
			// FIXME get Library array
			userChoice = Validator.getInt(scnr, 1, 3);
			switch(userChoice) {
			case 1:
				// Display
				break;
			case 2:
				// Search
				break;
			case 3:
				// Return
			break;
			default:
				userContinue = false;
			}
		} while (userContinue);
>>>>>>> 70cbe9f235786bf9a6dca6861cb20853f24c9f90
	}
}


