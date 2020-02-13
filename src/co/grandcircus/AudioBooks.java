package co.grandcircus;

import java.util.ArrayList;

public class AudioBooks {

	static FileHelper<AudioBook> fileHelper = new FileHelper<>("AudioBooks.txt", (new AudioBookLineConverter()));

	public static ArrayList<AudioBook> getAudioBookList() {
		
		// adding audio books

		ArrayList<AudioBook> audioBooks = new ArrayList<>();

		audioBooks.add(new AudioBook("Everyone’s a Aliebn When UR a Aliebn Too", false, 92, "Jomny Sun"));
		audioBooks.add(new AudioBook("The Poet X", false, 183, "Elizabeth Acevedo"));
		audioBooks.add(new AudioBook("Convenience Store Woman", false, 201, "Sayaka Murata"));
		audioBooks.add(new AudioBook("Barracoon: The Story of the Last", false, 229, "Zora Neale"));
		audioBooks.add(new AudioBook("Marcus Vega Doesn’t Speak Spanish", false, 315, "Pablo Cartaya"));
		audioBooks.add(new AudioBook("The Ravenmaster", false, 399, "Christopher Skaife"));
		audioBooks.add(new AudioBook("Sadie", false, 477, "Courtney Summers"));
		audioBooks.add(new AudioBook("There, there", false, 480, "Tommy Orange"));
		audioBooks.add(new AudioBook("Not That Bad: Dispatches from Rape Culture", false, 521, "Roxane Gay"));
		audioBooks.add(new AudioBook("An Absolutely Remarkable Thing", false, 565, "Hank Green"));
		audioBooks.add(new AudioBook("The Girl Who Drank the Moon", false, 571, "Kelly Barnhill"));
		audioBooks.add(new AudioBook("One Day in December", false, 627, "Josie Silver"));
		audioBooks.add(new AudioBook("All the Ever Afters: The Untold Story of Cinderella’s Stepmother", false, 650,
				"Danielle Teller"));
		audioBooks.add(new AudioBook("The Radical King", false, 673, "Martin Luther King, Jr"));
		audioBooks.add(new AudioBook("Circe", false, 728, "Madeline Miller"));

		return audioBooks;

	}
	
	public static void audioBooksToFile(ArrayList<AudioBook> audioBooks) { // can be used to write an array to the text file
		fileHelper.rewrite(audioBooks);

	}

}
