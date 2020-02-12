package co.grandcircus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DVDs {

	static FileHelper<DVD> fileHelper = new FileHelper<>("DVDs.txt", (new DVDLineConverter()));
	// creates means to send and retrieve information from DVDs.txt

	public static ArrayList<DVD> getDVDList() {

		ArrayList<DVD> dvds = new ArrayList<>(); // creates a date format, and passes the string date into a date
													// variable
		DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yy");
		String dueDate = "3/1/20";
		LocalDate setDueDate = LocalDate.parse(dueDate, format);

		dvds.add(new DVD("The Godfather", false, setDueDate, 178, "Francis Ford Coppola"));// starter DVD list
		dvds.add(new DVD("The Wizard of Oz", false, setDueDate, 112, "Victor Flemming"));
		dvds.add(new DVD("Citizen Kane", false, setDueDate, 119, "Orson Welles"));
		dvds.add(new DVD("The Shawshank Redemption", false, setDueDate, 142, "Frank Darabont"));
		dvds.add(new DVD("Pulp Fiction", false, setDueDate, 178, "Quentin Tarantino"));
		dvds.add(new DVD("Casablanca", false, setDueDate, 102, "Michael Cuutiz"));
		dvds.add(new DVD("The Godfather: Pt II", false, setDueDate, 202, "Francis Ford Coppola"));
		dvds.add(new DVD("E.T. The Extra Terrestrial", false, setDueDate, 121, "Steven Speilberg"));
		dvds.add(new DVD("2001: A Space Odyssey", false, setDueDate, 164, "Stanley Kubrick"));
		dvds.add(new DVD("Schindler's List", false, setDueDate, 197, "Steven Speilberg"));

		/*
		dvds.add(new DVD("Raging Bill", false, setDueDate, 129, "Martin Scorsese"));
		dvds.add(new DVD("Gone with the Wind", false, setDueDate, 238, "Sam Wood"));
		dvds.add(new DVD("One Flew Over the Cuckoos Nest", false, setDueDate, 133, "Milos Forman"));
		dvds.add(new DVD("Lawrence of Arabia", false, setDueDate, 228, "David Lean"));
		dvds.add(new DVD("Vertigo", false, setDueDate, 128, "Alfred Hitchcock"));
		dvds.add(new DVD("Psycho", false, setDueDate, 109, "Alfred Hitchcock"));
		dvds.add(new DVD("On the Waterfront", false, setDueDate, 108, "Elia Kazan"));
		dvds.add(new DVD("Forrest Gump", false, setDueDate, 142, "Robert Zemeckis"));
		dvds.add(new DVD("2001: A Space Odyssey", false, setDueDate, 149, "Stanley Kubrick"));
		dvds.add(new DVD("E.T. the Extra-Terrestrial", false, setDueDate, 115, "Steven Spielberg"));

		*/
		return dvds;

	}

	public static void DVDsToFile(ArrayList<DVD> dvds) { // can be used to write an array to the text file
		fileHelper.rewrite(dvds);

	}

	public static ArrayList<Media> mediaFromFiles() { // writes an array from the text file
		ArrayList<Media> media = (ArrayList) fileHelper.readAll();
		media.addAll(Books.fileHelper.readAll()); // pulls the book text file as well so there is only one array
		return media;
	}

}
