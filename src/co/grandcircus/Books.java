package co.grandcircus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Books {

	static FileHelper<Book> fileHelper = new FileHelper<>("Books.txt", (new BookLineConverter()));

	public static ArrayList<Book> getBookList() { // see DVDs for details, same principles for all methods

		ArrayList<Book> books = new ArrayList<>();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yy");
		String dueDate = "3/1/20";
		LocalDate setDueDate = LocalDate.parse(dueDate, format);

		books.add(new Book("To kill a Mockingbird", false, setDueDate, "Harper Lee"));
		books.add(new Book("Ulysses", false, setDueDate, "James Joyce"));
		books.add(new Book("The Great Gatsby", false, setDueDate, "F. Scott Fitzgerald"));
		books.add(new Book("A Portrait of the Artist as a Young Man", false, setDueDate, "James Joyce"));
		books.add(new Book("Lolita", false, setDueDate, "Vladimir Nabokov"));
		books.add(new Book("Brave New World", false, setDueDate, "Aldous Huxley"));
		books.add(new Book("The Sound and the Fury", false, setDueDate, "William Faulkner"));
		books.add(new Book("Catch-22", false, setDueDate, "Joseph Heller"));
		books.add(new Book("Darkness At Noon", false, setDueDate, "Arthur Koestler"));
		books.add(new Book("Sons and Lovers", false, setDueDate, "D.H. Lawrence"));

		/*
		books.add(new Book("In Search of Lost Time", false, setDueDate, "Marcel Proust"));
		books.add(new Book("Don Quixote", false, setDueDate, "Miguel de Cervantes"));
		books.add(new Book("One Hundred Years of Solitude", false, setDueDate, "Gabriel Garcia Marquez"));
		books.add(new Book("Moby Dick", false, setDueDate, "Herman Melville"));
		books.add(new Book("War and Peace", false, setDueDate, "Leo Tolstoy"));
		books.add(new Book("Hamlet", false, setDueDate, "William Shakespeare"));
		books.add(new Book("The Catcher in the Rye", false, setDueDate, "J. D. Salinger"));
		books.add(new Book("The Odyssey", false, setDueDate, "Homer"));
		books.add(new Book("The Brothers Karamazov", false, setDueDate, "Fyodor Dostoyevsky"));
		books.add(new Book("Crime and Punishment", false, setDueDate, "Fyodor Dostoyevsky"));
		*/

		return books;

	}

	public static void BooksToFile(ArrayList<Book> bookList) {
		fileHelper.rewrite(bookList);

	}

}
