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

		line.split("\t");

		boolean status;
		String dueDate = "";

		String[] lines = line.split("\t");
		String title = lines[0];
		if (lines[1].equals("true")) {
			status = true;
		} else {
			status = false;
		}

		DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yy");
		dueDate = lines[2];
		LocalDate setDueDate = LocalDate.parse(dueDate, format);

		int runtime = Integer.parseInt(lines[3]);
		String director = lines[4];

		return new DVD(title, status, setDueDate, runtime, director);
	}

}
