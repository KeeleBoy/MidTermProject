package co.grandcircus;

import java.time.LocalDate;

public abstract class Media {

	String title;
	boolean status;
	LocalDate dueDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	/*
	 * @Override public String toString() { return "Media [title=" + title +
	 * ", status=" + status + ", dueDate=" + dueDate + "]"; }
	 */

}
