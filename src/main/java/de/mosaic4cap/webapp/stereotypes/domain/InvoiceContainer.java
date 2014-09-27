package de.mosaic4cap.webapp.stereotypes.domain;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import de.mosaic4cap.webapp.stereotypes.entities.Invoice;
import de.mosaic4cap.webapp.stereotypes.entities.Store;
import de.mosaic4cap.webapp.stereotypes.enumeration.InvoiceType;

/**
 * Created by Lobedan on 22.09.2014. *
 * <p>
 * Container for invoice objects with some buisnesslogic in it
 */
public class InvoiceContainer extends Container {
	private static final Logger LOGGER = Logger.getLogger(InvoiceContainer.class);

	private Date date;
	private List<Invoice> partials;
	private Store store;
	private InvoiceType state = InvoiceType.OPEN;

	public InvoiceContainer() {
	}

	public InvoiceContainer(Date pDate, List<Invoice> pPartials, Store pStore) {
		date = pDate;
		partials = pPartials;
		store = pStore;
	}

	public Double getEcAmount() {
		double sum = 0.00;
		for (Invoice s : partials) {
      for (Double d : s.getEcpayment()) {
				sum += d;
			}
		}
		return sum;
	}

	public Double getBillAmount() {
    double sum = 0.00;
		for (Invoice s : partials) {
      for (Double d : s.getBills()) {
        sum += d;
			}
		}
		return sum;
	}

	public Double getAmount() {
		double sum = 0.00;
		for (Invoice s : partials) {
			sum += s.getIncome();
		}
		return sum;
	}

	public int getEcCount() {
		int sum = 0;
		for (Invoice invoice : partials) {
			sum += invoice.getEcpayment().size();
		}
		return sum;
	}

	public int getBillCount() {
		int sum = 0;
		for (Invoice invoice : partials) {
			sum += invoice.getBills().size();
		}
		return sum;
	}

	public int getPartialsCount() {
		return partials.size();
	}

	public InvoiceType getState() {
		return state;
	}

	public void setState(InvoiceType aState) {
		state = aState;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store pStore) {
		store = pStore;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date pDate) {
		date = pDate;
	}

	public List<Invoice> getPartials() {
		return partials;
	}

	public void setPartials(List<Invoice> pPartials) {
		partials = pPartials;
	}

	@Override
	public String toString() {
		return "InvoiceContainer{" +
					 "date=" + date +
					 ", partials=" + partials +
					 ", store=" + store +
					 ", state=" + state +
					 '}';
	}
}
