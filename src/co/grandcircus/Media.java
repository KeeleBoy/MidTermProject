package co.grandcircus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Media {



	String title;
	boolean checkedOut;
	LocalDate dueDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public boolean isCheckedOut() {
		return checkedOut;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	public String getDueDate() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yy");
		return dueDate.format(format);
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	

}
