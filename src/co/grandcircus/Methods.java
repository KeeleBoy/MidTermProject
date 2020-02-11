package co.grandcircus;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Methods {
	
	public void printMenu() {
		System.out.println("==================[   LIBRARY MENU   ]==============================");
		System.out.println("   [1]   Display");
		System.out.println("   [2]   Search");
		System.out.println("   [3]   Return");		
		System.out.println("   [4]   Exit");
		System.out.println("====================================================================");

	}
	
	public void byDirector(String director, List<Media> library) {
		director = director.toUpperCase();
		for (Media m : library) {
			if (m instanceof DVD) {
				DVD dvdm = (DVD) m;
				if (dvdm.getDirector().toUpperCase().contains(director)) {
					System.out.println(m);
				}
			}
		}
	}
	public void byAuthor(String author, List<Media> library) {
		author = author.toUpperCase();
		for (Media m : library) {
			if (m instanceof Book) {
				Book bookm = (Book) m;
				if (bookm.getAuthor().toUpperCase().contains(author)) {
					System.out.println(m);
				}
			}
		}
	}
	
	public void byTitle(String title, List<Media> library) {
		title = title.toUpperCase();
		for (Media m : library) {
			if (m.getTitle().toUpperCase().contains(title)) {
				System.out.println(m);
			}
		}
	}
	
	public void checkout(Media media, Scanner scnr) {
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
}
