package co.grandcircus;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class DVD extends Media {

	int runtime;
	List<String> director;

	public DVD() { // no args constructor
		super();
	}

	public DVD(String title, boolean checkedOut, LocalDate dueDate, int runtime, String director) { //constructor

		this.title = title;
		this.checkedOut = checkedOut;
		this.dueDate = dueDate;
		this.runtime = runtime;
		setDirector(director);
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public String getDirector() {  //gets director from list to string
		String returnDirector = "";
		for (String d : director) {
			returnDirector += d + ", ";
		}
		returnDirector = returnDirector.substring(0, returnDirector.length() - 2);
		return returnDirector;
	}

	public void setDirector(String director) { // sets director from string to list
		List<String> directorList = Arrays.asList(director.split(", "));
		this.director = directorList;
	}

	@Override
	public String toString() { // toString method, has 2 options for whether DVD is checked out
		String dvdString = "\"" + title + "\" by " + getDirector() + ", Runtime: " + runtime + "m";
		if (checkedOut) {
			return String.format("%-60s%35s", dvdString, "Unavailable until " + getDueDate());

		} else {
			return String.format("%-60s%35s", "\"" + title + "\" by " + getDirector(), "Available");
		}

	}

}
