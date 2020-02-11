package co.grandcircus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DVD extends Media {

	int runtime;
	String director;

	public DVD() {
		super();
	}

	public DVD(String title, boolean status, LocalDate dueDate, int runtime, String director) {
		
		this.title = title;
		this.status = status;
		this.dueDate = dueDate;
		this.runtime = runtime;
		this.director = director;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		
		if (status) {
			return "DVD [director= " + director + ", title= " + title + ", runtime= " + runtime + ", status= Checked out"
					+ ", dueDate=" + dueDate + "]";
			
		} else {		
		
		return "DVD [director= " + director + ", title= " + title + ", runtime= " + runtime + ", status= Available";
		}
	}
	
	

}
