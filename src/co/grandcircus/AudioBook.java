package co.grandcircus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class AudioBook extends Media {
	
	// variables 

	int runtime;
	List<String> author;

	// no argument constructor
	
	public AudioBook() {

	}
	
	// normal constructor

	public AudioBook(String title, boolean checkedOut, int runtime,  String author) {
		super();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yy");
		String dueDate = "3/1/20";
		LocalDate setDueDate = LocalDate.parse(dueDate, format);
		this.title = title;
		setAuthor(author);
		this.checkedOut = checkedOut;
		this.runtime = runtime;
		this.dueDate = setDueDate;
	}
	
	public AudioBook(String title, boolean checkedOut, LocalDate dueDate, int runtime,  String author) {
		super();
		this.title = title;
		setAuthor(author);
		this.checkedOut = checkedOut;
		this.runtime = runtime;
		this.dueDate = dueDate;
	}

	// to string

	@Override
	public String toString() {
		String audioBookString = "\"" + title + "\" by " + getAuthor() + ", Runtime: " + runtime + "m";
		if (checkedOut) {
			return String.format("%-80s%20s", audioBookString, "Unavailable until " + getDueDate());
		} else {
			return String.format("%-80s%20s", audioBookString,  "Available");
		}

	}
	
	// getters and setters below

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public String getAuthor() { // gets Authors from list to string for easier management
		String returnAuthor = "";
		for (String a : author) {
			returnAuthor += a + ", ";
		}
		returnAuthor = returnAuthor.substring(0, returnAuthor.length() - 2);
		return returnAuthor;
	}



	public void setAuthor(String author) { //sets author from List
		List<String> authorList = Arrays.asList(author.split(", "));
		this.author = authorList;
	}

}
