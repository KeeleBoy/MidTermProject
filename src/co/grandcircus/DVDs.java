package co.grandcircus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DVDs {

	static FileHelper<DVD> fileHelper = new FileHelper<>("DVDs.txt", (new DVDLineConverter()));

	public static void DVDAdd() {

		DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yy");
		String dueDate = "3/1/20";
		LocalDate setDueDate = LocalDate.parse(dueDate, format);

		DVD dvd1 = new DVD("The Godfather", false, setDueDate, 178, "Francis Ford Coppola");

		fileHelper.append(dvd1);
	}

}
