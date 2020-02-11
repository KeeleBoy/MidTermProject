package co.grandcircus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookLineConverter implements LineConverter<Book> {

	@Override
	public String toLine(Book object) {
		return String.format("%s\t%s\t%s\t%s", object.getTitle(), object.isStatus(), object.getDueDate(),
				object.getAuthor());
	}

	@Override
	public Book fromLine(String line) {

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

		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-dd-MM");
		dueDate = lines[2];
		LocalDate setDueDate = LocalDate.parse(dueDate, format);
		String author = lines[3];

		return new Book(title, status, setDueDate, author);
	}

}
