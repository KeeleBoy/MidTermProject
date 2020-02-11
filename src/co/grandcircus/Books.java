package co.grandcircus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Books {

	public static void bookAdd() {

		static FileHelper<Book> fileHelper = new FileHelper<>("Books.txt", (new BookLineConverter()));

		DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yy");
		String dueDate = "1/1/99";
		LocalDate setDueDate = LocalDate.parse(dueDate, format);
		Book Book1 = new Book("To kill a Mockingbird", false, setDueDate, "Harper Lee");

		Main.fileHelper.append(Book1);

	}

}
