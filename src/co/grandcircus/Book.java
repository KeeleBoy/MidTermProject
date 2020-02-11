package co.grandcircus;

import java.time.LocalDate;

public class Book extends Media {

	String author;

	public Book() {

	}

	public Book(String title, boolean status, LocalDate dueDate, String author) {
		super();
		this.title = title;
		this.status = status;
		this.dueDate = dueDate;
		this.author = author;

	}

	@Override
	public String toString() {
		return "Book [author=" + author + "]";
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
