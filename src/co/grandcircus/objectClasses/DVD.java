package co.grandcircus.objectClasses;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class DVD extends Media {

	int runtime;
	List<String> director;

	public DVD() {
		super();
	}

	public DVD(String title, boolean checkedOut, LocalDate dueDate, int runtime, String director) {

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

	public String getDirector() {
		String returnDirector = "";
		for (String d : director) {
			returnDirector += d + ", ";
		}
		returnDirector = returnDirector.substring(0, returnDirector.length() - 2);
		return returnDirector;
	}

	public void setDirector(String director) {
		List<String> directorList = Arrays.asList(director.split(", "));
		this.director = directorList;
	}

	@Override
	public String toString() {
		String dvdString = "\"" + title + "\" by " + getDirector() + ", Runtime: " + runtime + "m";
		if (checkedOut) {
			return String.format("%-60s%35s", dvdString, "Unavailable until " + getDueDate());

		} else {
			return String.format("%-60s%35s", "\"" + title + "\" by " + getDirector(), "Available");
		}

	}

}
