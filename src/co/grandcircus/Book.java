package co.grandcircus;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Book extends Media {

	List<String> author;

	public Book() { // no args constructor

	}

	public Book(String title, boolean checkedOut, LocalDate dueDate, String author) { //constructor
		super();
		this.title = title;
		this.checkedOut = checkedOut;
		this.dueDate = dueDate;
		setAuthor(author);
	}

	@Override
	public String toString() { // toString, 2 options for whether or not the book is checked out
		String bookString = "\"" + title + "\" by " + getAuthor();
		if (checkedOut) {
			return String.format("%-80s%20s", bookString, "Unavailable until " + getDueDate());

		} else {
			return String.format("%-80s%20s", "\"" + title + "\" by " + getAuthor(), "Available");
		}

	}


	public String getAuthor() { //gets author from list 
		String returnAuthor = "";
		for (String a : author) {
			returnAuthor += a + ", ";
		}
		returnAuthor = returnAuthor.substring(0, returnAuthor.length() - 2);
		return returnAuthor;
	}



	public void setAuthor(String author) {// sets author as a list so multiple authors can be held
		List<String> authorList = Arrays.asList(author.split(", "));
		this.author = authorList;
	}

}
