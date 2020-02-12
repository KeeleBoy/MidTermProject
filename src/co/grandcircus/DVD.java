package co.grandcircus;

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

		if (checkedOut) {
			return String.format("%-60s%20s", "\"" + title + "\" by " + getDirector() + " " + runtime + "m", "Unavailable until " + getDueDate());
//			return "DVD [director= " + director + ", title= " + title + ", runtime= " + runtime
//					+ ", status= Checked out" + ", dueDate=" + dueDate + "]";

		} else {

			return "DVD [director= " + director + ", title= " + title + ", runtime= " + runtime + ", status= Available";
		}
	}

}
