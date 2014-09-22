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
	OPEN, CLOSED, PENDING;
}
