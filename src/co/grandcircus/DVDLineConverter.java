package co.grandcircus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DVDLineConverter implements LineConverter<DVD> {

	@Override
	public String toLine(DVD object) {
		return String.format("%s\t%s\t%s\t%s\t%s", object.getTitle(), object.isStatus(), object.getDueDate(),
				object.getRuntime(), object.getDirector());
	}

	@Override
	public DVD fromLine(String line) {

<<<<<<< HEAD
		line.split("\t");

=======
		line.split("\t"); // creates a means of splitting lines at tab at tab
		
>>>>>>> 5d2e136fd05963e5dfd3cecf60ccfa2eb71360f0
		boolean status;
		String dueDate = "";

		String[] lines = line.split("\t"); //actually splits the lines into an array
		String title = lines[0];// first segment becomes the title
		if (lines[1].equals("true")) {//if then statement for the status
			status = true; // if line reads true, then the status becomes true
		} else {
			status = false; // otherwise status becomes false
		}
<<<<<<< HEAD

		DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yy");
=======
		
<<<<<<< HEAD
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-dd-MM");
>>>>>>> 211f4fb0bda4cdbdacc26dc7caef8a1626d68be4
		dueDate = lines[2];
		LocalDate setDueDate = LocalDate.parse(dueDate, format);

		int runtime = Integer.parseInt(lines[3]);
		String director = lines[4];
=======
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-dd-MM"); // pulls the 3rd segment and creates a Date variable
		dueDate = lines[2];
		LocalDate setDueDate = LocalDate.parse(dueDate, format);
		
		
		int runtime = Integer.parseInt(lines[3]); // pulls the 4th segment for the runtime portion of the DVD
		String director = lines[4]; // pulls the 5th segment for the director
>>>>>>> 5d2e136fd05963e5dfd3cecf60ccfa2eb71360f0

		return new DVD(title, status, setDueDate, runtime, director); // inputs all new variables into a new DVD
	}

}
