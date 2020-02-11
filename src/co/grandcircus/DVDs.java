package co.grandcircus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DVDs {

	static FileHelper<DVD> fileHelper = new FileHelper<>("DVDs.txt", (new DVDLineConverter()));

	
	public static ArrayList<DVD >getDVDList() {
		
		ArrayList<DVD> dvds = new ArrayList<>();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yy");
		String dueDate = "3/1/20";
		LocalDate setDueDate = LocalDate.parse(dueDate, format);
		
		dvds.add(new DVD("The Godfather", false, setDueDate, 178, "Francis Ford Coppola"));
		dvds.add(new DVD("The Wizard of Oz", false, setDueDate, 112, "Victor Flemming"));
		dvds.add(new DVD("Citizen Kane", false, setDueDate, 119, "Orson Welles"));
		dvds.add(new DVD("The Shawshank Redemption", false, setDueDate, 142, "Frank Darabont"));
		dvds.add(new DVD("Pulp Fiction", false, setDueDate, 178, "Quentin Tarantino"));
		dvds.add(new DVD("Casablanca", false, setDueDate, 102, "Michael Cuutiz"));
		dvds.add(new DVD("The Godfather: Pt II", false, setDueDate, 202, "Francis Ford Coppola"));
		dvds.add(new DVD("E.T. The Extra Terrestrial", false, setDueDate, 121, "Steven Speilberg"));
		dvds.add(new DVD("2001: A Space Odyssey", false, setDueDate, 164, "Stanley Kubrick"));
		dvds.add(new DVD("Schindler's List", false, setDueDate, 197, "Steven Speilberg"));
		
		return dvds;

	}

	public static void DVDsToFile(ArrayList<DVD> dvds) {
			fileHelper.rewrite(dvds);
		
	}

}
