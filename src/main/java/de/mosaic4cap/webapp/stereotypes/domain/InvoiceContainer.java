package de.mosaic4cap.webapp.stereotypes.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import de.mosaic4cap.webapp.stereotypes.entities.Invoice;
import de.mosaic4cap.webapp.stereotypes.entities.Store;

/**
 * Created by Lobedan on 22.09.2014. *
 * <p/>
 * Container for invoice objects with some buisnesslogic in it
 */
public class InvoiceContainer extends Container {
 private static final Logger LOGGER = Logger.getLogger(InvoiceContainer.class);

 private Date date;
 private List<Invoice> partials;
 private Store store;

 public InvoiceContainer() {
 }

 public InvoiceContainer(Date pDate, List<Invoice> pPartials, Store pStore) {
	date = pDate;
	partials = pPartials;
	store = pStore;
 }

 public BigDecimal getECAmount() {
	BigDecimal sum = new BigDecimal(0);
	for (Invoice s : partials) {
	 for (BigDecimal b : s.getEcpayment()) {
		sum = sum.add(b);
	 }
	}
	return sum;
 }

 public BigDecimal getBillAmount() {
	BigDecimal sum = new BigDecimal(0);
	for (Invoice s : partials) {
	 for (BigDecimal b : s.getBills()) {
		sum = sum.add(b);
	 }
	}
	return sum;
 }

 public BigDecimal getAmount() {
	BigDecimal sum = new BigDecimal(0);
	for (Invoice s : partials) {
	 sum = sum.add(s.getIncome());
	}
	return sum;
 }

 public int getPartialsCount() {
	return partials.size();
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
}
