package co.grandcircus;

import java.time.LocalDate;

public class BookLineConverter implements LineConverter<Book> {

	@Override
	public String toLine(Book object) {
		return String.format("%s\t%s\t%s", object.getTitle(), object.isStatus(), object.getDueDate(),
				object.getAuthor());
	}

	@Override
	public Book fromLine(String line) {

		line.split("\t");

		String[] lines = line.split("\t");
		String title = lines[0];
		boolean status = lines[1];
		LocalDate dueDate = lines[2];
		String author = lines[4];

		return new Book(title, status, dueDate, author);
	}

}
