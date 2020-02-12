package co.grandcircus;

import java.time.LocalDate;

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

	public boolean isStatus() {
		return checkedOut;
	}

	public void setStatus(boolean status) {
		this.checkedOut = status;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

}
