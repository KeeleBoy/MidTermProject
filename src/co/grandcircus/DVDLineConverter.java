package co.grandcircus;

import java.time.LocalDate;

public class DVDLineConverter implements LineConverter<DVD> {

	@Override
	public String toLine(DVD object) {
		return String.format("%s\t%s\t%s", object.getTitle(), object.isStatus(), object.getDueDate(),
				object.getRuntime(), object.getDirector());
	}

	@Override
	public DVD fromLine(String line) {

		line.split("\t");

		String[] lines = line.split("\t");
		String title = lines[0];
		boolean status = lines[1];
		LocalDate dueDate = lines[2];
		int runtime = Integer.parseInt(lines[3]);
		String director = lines[4];

		return new DVD(title, status, dueDate, runtime, director);
	}

}
