package de.mosaic4cap.webapp.chefui.services.notification;

import java.util.Date;

/**
 * Created by svenklemmer on 19.09.14.
 * <p>
 * Object representing notification displayed
 * in header part of application
 */
public class Notification implements Comparable<Notification> {

	private NotificationType type;
	private String title;
	private String message;
	private Date date;
	private boolean hasRead = false;

	public Notification() {
	}

	public Notification(NotificationType aType, String aTitle, String aMessage, Date aDate) {
		type = aType;
		title = aTitle;
		message = aMessage;
		date = aDate;
	}

	public boolean isHasRead() {
		return hasRead;
	}

	public void setHasRead(boolean aHasRead) {
		hasRead = aHasRead;
	}

	public NotificationType getType() {
		return type;
	}

	public void setType(NotificationType aType) {
		type = aType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String aTitle) {
		title = aTitle;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String aMessage) {
		message = aMessage;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date aDate) {
		date = aDate;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Notification that = (Notification) o;

		if (date != null ? !date.equals(that.date) : that.date != null) {
			return false;
		}
		if (message != null ? !message.equals(that.message) : that.message != null) {
			return false;
		}
		if (title != null ? !title.equals(that.title) : that.title != null) {
			return false;
		}
		if (type != that.type) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = type != null ? type.hashCode() : 0;
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (message != null ? message.hashCode() : 0);
		result = 31 * result + (date != null ? date.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Notification{" +
					 "type=" + type +
					 ", title='" + title + '\'' +
					 ", message='" + message + '\'' +
					 ", date=" + date +
					 '}';
	}

	@Override
	public int compareTo(Notification o) {
		return 0;
	}
}

