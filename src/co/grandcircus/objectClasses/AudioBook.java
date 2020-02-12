package co.grandcircus.objectClasses;

import java.util.Arrays;
import java.util.List;

public class AudioBook extends Media {

	int runtime;
	List<String> author;

	public AudioBook() {

	}

	public AudioBook(int runtime, String title, boolean checkedOut, String author) {
		super();
		this.title = title;
		setAuthor(author);
		this.checkedOut = checkedOut;
		this.runtime = runtime;
	}

	public AudioBook(String string, boolean b, int i, String string2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AudioBook [runtime=" + runtime + ", title=" + title + ", checkedOut=" + checkedOut + ", dueDate="
				+ dueDate + "]";
	}

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
