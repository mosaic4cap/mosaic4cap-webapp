package de.mosaic4cap.webapp.stereotypes.enumeration;

/**
 * Created by Lobedan on 22.09.2014.
 * <p>
 * Simple enum type pointing to state of an invoice
 * its also used for {@link de.mosaic4cap.webapp.stereotypes.domain.InvoiceContainer}
 * <p>
 * Open: Invoice is in list and not checked
 * Closed: Invoice is already checked and finished
 * Pending: Invoice is still inside checking process, means its not
 * open and still not closed
 */
public enum InvoiceType {
	OPEN("Offen", " label-danger"),
	CLOSED("Abgeschlossen", " label-success"),
	PENDING("In Bearbeitung", " label-warning");

	private String txt;
	private String cssClass;

	InvoiceType(String aTxt, String aCssClass) {
		txt = aTxt;
		cssClass = aCssClass;
	}

	public String getCssClass() {

		return cssClass;
	}

	public void setCssClass(String aCssClass) {
		cssClass = aCssClass;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String aTxt) {
		txt = aTxt;
	}
}
