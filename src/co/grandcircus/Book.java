package co.grandcircus;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Book extends Media {

	List<String> author;

	public Book() {

	}

	public Book(String title, boolean checkedOut, LocalDate dueDate, String author) {
		super();
		this.title = title;
		this.checkedOut = checkedOut;
		this.dueDate = dueDate;
		setAuthor(author);
	}

	@Override
	public String toString() {

		if (checkedOut) {			
			return String.format("%-60s%39s", "\"" + title + "\" by " + getAuthor(), "Unavailable until " + getDueDate());
		} else {		
		
			return String.format("%-60s%39s", "\"" + title + "\" by " + getAuthor(), "");
		}
	}

	public String getAuthor() {
		String returnAuthor = "";
		for (String a : author) {
			returnAuthor += a + ", ";
		}
		returnAuthor = returnAuthor.substring(0, returnAuthor.length() - 2);
		return returnAuthor;
	}

	public void setAuthor(String author) {
		List<String> authorList = Arrays.asList(author.split(", "));
		this.author = authorList;
	}

}
