package co.grandcircus;

import java.util.ArrayList;

public class AudioBooks {

	static FileHelper<AudioBook> fileHelper = new FileHelper<>("AudioBooks.txt", (new AudioBookLineConverter()));

	public static ArrayList<AudioBook> getAudioBookList() {

		ArrayList<AudioBook> audioBooks = new ArrayList<>();

		return audioBooks;

		/*
		 * Audio books to add
		 * audioBooks.add(new AudioBook(""", false, setDueDate, 178, ""));
		 * audioBooks.add(new AudioBook(""", false, setDueDate, 178, ""));
		 * audioBooks.add(new AudioBook(""", false, setDueDate, 178, ""));
		 * audioBooks.add(new AudioBook(""", false, setDueDate, 178, ""));
		 * audioBooks.add(new AudioBook(""", false, setDueDate, 178, ""));
		 * audioBooks.add(new AudioBook(""", false, setDueDate, 178, ""));
		 * audioBooks.add(new AudioBook(""", false, setDueDate, 178, ""));
		 * audioBooks.add(new AudioBook(""", false, setDueDate, 178, ""));
		 * audioBooks.add(new AudioBook(""", false, setDueDate, 178, ""));
		 * audioBooks.add(new AudioBook(""", false, setDueDate, 178, ""));
		 * audioBooks.add(new AudioBook(""", false, setDueDate, 178, ""));
		 * audioBooks.add(new AudioBook(""", false, setDueDate, 178, ""));
		 * audioBooks.add(new AudioBook(""", false, setDueDate, 178, ""));
		 * audioBooks.add(new AudioBook(""", false, setDueDate, 178, ""));
		 * audioBooks.add(new AudioBook(""", false, setDueDate, 178, ""));
		 * 
		 */

	}

}
