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

	// to string

	@Override
	public String toString() {
		String audioBookString = "\"" + title + "\" by " + getAuthor() + ", Runtime: " + runtime + "m";
		if (checkedOut) {
			return String.format("%-60s%35s", audioBookString, "Unavailable until " + getDueDate());

		} else {
			return String.format("%-60s%35s", "\"" + title + "\" by " + getAuthor(),  "Available");
		}

	}
	
	// getters and setters below

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
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
