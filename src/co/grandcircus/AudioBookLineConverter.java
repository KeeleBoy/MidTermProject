package co.grandcircus;

public class AudioBookLineConverter implements LineConverter<AudioBook> {

	@Override
	public String toLine(AudioBook object) {
		return String.format("%s\t%s\t%s\t%s", object.getTitle(), object.getAuthor(), object.isStatus(),
				object.getRuntime());
	}

	@Override
	public AudioBook fromLine(String line) {

		line.split("\t"); // creates a means of splitting lines at tab at tab
		boolean status;

		String[] lines = line.split("\t"); // actually splits the lines into an array
		String title = lines[0];// first segment becomes the title
		String author = lines[1];
		if (lines[1].equals("true")) {// if then statement for the status
			status = true; // if line reads true, then the status becomes true
		} else {
			status = false; // otherwise status becomes false
		}

		int runtime = Integer.parseInt(lines[3]); // pulls the 4th segment for the runtime portion of the DVD

		return new AudioBook(runtime, author, status, title); // inputs all new variables into a new DVD
	}

}
