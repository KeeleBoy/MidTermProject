package co.grandcircus;

import java.util.Arrays;
import java.util.List;

public class AudioBook extends Media {

	// added run time

	int runtime;
	List<String> author;

	// no argument constructor

	public AudioBook() {

		// normal constructor

	}

	public AudioBook(int runtime, String title, boolean checkedOut, String author) {
		super();
		this.title = title;
		setAuthor(author);
		this.checkedOut = checkedOut;
		this.runtime = runtime;
	}

	// to string

	public AudioBook(String string, boolean b, int i, String string2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AudioBook [runtime=" + runtime + ", title=" + title + ", checkedOut=" + checkedOut + ", dueDate="
				+ dueDate + "]";
	}

	// getters and setters below

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public void setAuthor(String author) {
		List<String> authorList = Arrays.asList(author.split(", "));
		this.author = authorList;
	}
	public List<String> getAuthor() {
		return author;
	}

}
