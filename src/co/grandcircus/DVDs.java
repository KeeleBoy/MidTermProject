package co.grandcircus;

public class DVDs {
	
	static FileHelper<DVD> fileHelper = new FileHelper<>("DVDs.txt", (new DVDLineConverter()));

}
