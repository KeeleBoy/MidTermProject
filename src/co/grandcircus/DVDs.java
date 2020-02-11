package co.grandcircus;

public class DVDs {
	
	static FileHelper<DVD> fileHelper = new FileHelper<>("countries.txt", (new DVDLineConverter()));

}
