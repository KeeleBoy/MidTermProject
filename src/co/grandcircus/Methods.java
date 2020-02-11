package co.grandcircus;

import java.util.List;

public class Methods {
	
	public void printMenu() {
		System.out.println("===================   MENU   ===================");
		System.out.println("   [1]   Display");
		System.out.println("   [2]   Search");
		System.out.println("   [3]   Return");		
	}
	
	public void byDirector(String director, List<Media> library) {
		director = director.toUpperCase();
		for (Media m : library) {
			if (m instanceof DVD) {
				DVD dvdm = (DVD) m;
				if (m.getDirector().toUpperCase().contains(director)) {
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
				if (m.getAuthor().toUpperCase().contains(author)) {
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
	
	public void checkout(Media media) {
		System.out.println(media);
		System.out.println("Due Date: " media.getDueDate().plusDays(14));
		
	}
}
