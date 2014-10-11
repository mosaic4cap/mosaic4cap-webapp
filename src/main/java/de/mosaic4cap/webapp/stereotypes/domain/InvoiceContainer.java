package de.mosaic4cap.webapp.stereotypes.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import org.apache.log4j.Logger;

import de.mosaic4cap.webapp.stereotypes.entities.Invoice;
import de.mosaic4cap.webapp.stereotypes.entities.Store;
import de.mosaic4cap.webapp.stereotypes.enumeration.InvoiceType;

/**
 * Created by Lobedan on 22.09.2014. *
 * <p>
 * Container for invoice objects with some buisnesslogic in it
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceContainer extends Container {
  private static final Logger LOGGER = Logger.getLogger(InvoiceContainer.class);

  private Date date;
  private List<Invoice> partials;
  private Store store;
  private InvoiceType state = InvoiceType.OPEN;
  private double amount = 0.00;
  private double ecAmount = 0.00;
  private double billAmount = 0.00;
  private int ecCount = 0;
  private int billCount = 0;

  public InvoiceContainer() {
  }

  public InvoiceContainer(Date pDate, List<Invoice> pPartials, Store pStore) {
    date = pDate;
    partials = pPartials;
    store = pStore;

		setEcAmount(0.00);
		setBillAmount(0.00);
		setAmount(0.00);
		setEcCount(0);
		setBillCount(0);

    state = areAllClosed() ? InvoiceType.CLOSED : InvoiceType.OPEN;
  }

	@JsonIgnore
  public boolean areAllClosed() {
    List<Boolean> closed = new ArrayList<>();

    partials.forEach(i -> closed.add(i.getState() == InvoiceType.CLOSED));
    return !closed.contains(false);
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double aAmount) {
    double sum = 0.00;
    if (aAmount == 0.00) {
      for (Invoice s : partials) {
        sum += s.getIncome();
      }
    } else {
      sum = aAmount;
    }
    this.amount = sum;
  }

  public double getEcAmount() {
    return ecAmount;
  }

  public void setEcAmount(double aEcAmount) {
    double sum = 0.00;
    if (aEcAmount == 0.00) {
      for (Invoice s : partials) {
        for (Double d : s.getEcpayment()) {
          sum += d;
        }
      }
    } else {
      sum = aEcAmount;
    }
    this.ecAmount = sum;
  }

  public double getBillAmount() {
    return billAmount;
  }

  public void setBillAmount(double aBillAmount) {
    double sum = 0.00;
    if (aBillAmount == 0.00) {
      for (Invoice s : partials) {
        for (Double d : s.getBills()) {
          sum += d;
        }
      }
    } else {
      sum = aBillAmount;
    }
    this.billAmount = sum;
  }

  public int getEcCount() {
    return ecCount;
  }

  public void setEcCount(int aEcCount) {
    int sum = 0;
    if (aEcCount == 0) {
      for (Invoice invoice : partials) {
        sum += invoice.getEcpayment().size();
      }
    } else {
      sum = aEcCount;
    }
    this.ecCount = sum;
  }

  public int getBillCount() {
    return billCount;
  }

  public void setBillCount(int aBillCount) {
    int sum = 0;
    if (aBillCount == 0) {
      for (Invoice invoice : partials) {
        sum += invoice.getBills().size();
      }
    } else {
      sum = aBillCount;
    }
    this.billCount = sum;
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
