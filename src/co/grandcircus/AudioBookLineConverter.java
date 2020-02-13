package co.grandcircus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AudioBookLineConverter implements LineConverter<AudioBook> {

	@Override
	public String toLine(AudioBook object) { // takes audiobook as an object and converts it to string for the text files
		return String.format("%s\t%s\t%s\t%s\t%s", object.getTitle(), object.isCheckedOut(),
				object.getDueDate(), object.getRuntime(), object.getAuthor());
	}

	@Override
	public AudioBook fromLine(String line) {

		line.split("\t"); // creates a means of splitting lines at tab at tab
		boolean status;

		String[] lines = line.split("\t"); // actually splits the lines into an array
		String title = lines[0];// first segment becomes the title
		String author = lines[4];
		if (lines[1].equals("true")) {// if then statement for the status
			status = true; // if line reads true, then the status becomes true
		} else {
			status = false; // otherwise status becomes false
		}
		DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yy");
		String dueDate = lines[2];
		LocalDate setDueDate = LocalDate.parse(dueDate, format);

		int runtime = Integer.parseInt(lines[3]); // pulls the 4th segment for the runtime portion of the DVD

		return new AudioBook(title, status, setDueDate, runtime, author); // inputs all new variables into a new DVD
	}

}
