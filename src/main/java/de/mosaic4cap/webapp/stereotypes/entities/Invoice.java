package de.mosaic4cap.webapp.stereotypes.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.log4j.Logger;

import de.mosaic4cap.webapp.stereotypes.enumeration.InvoiceType;

/**
 * Created by Lobedan on 30.08.2014.
 * <p>
 * Representing an invoice from a store
 */
@Entity
@Table(name = "invoice")
public class Invoice extends AbstractMosaic4CapEntity {
	private static final Logger LOGGER = Logger.getLogger(Invoice.class);

	private BigDecimal income;

//  @OneToMany(targetEntity = BigDecimal.class)
//  @JoinTable(name="invoice_bill")
//  @MapKeyColumn(name="billid", unique = false, nullable = true, insertable = true, updatable = true)
  @OneToMany(mappedBy = "id")
  private Set<BigDecimal> bills;

  @OneToMany(mappedBy = "id")
  private Set<BigDecimal> ecpayment;          //TODO: eigene Klasse für ec und bills (haben ja sowieso das gleiche schema)

 	@OneToOne
	private Driver driver;

	@OneToOne
	private Store store;

	@OneToOne
	private Car car;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Enumerated(EnumType.ORDINAL)
	private InvoiceType state = InvoiceType.OPEN;

	public Invoice() {
	}

  public Invoice(BigDecimal aIncome,
                 Set<BigDecimal> aBills,
                 Set<BigDecimal> aEcpayment,
                 Driver aDriver,
                 Store aStore,
                 Car aCar,
                 Date aDate) {
    income = aIncome;
    bills = aBills;
    ecpayment = aEcpayment;
    driver = aDriver;
    store = aStore;
    car = aCar;
    date = aDate;
  }

  public BigDecimal getIncome() {
    return income;

  }

  public void setIncome(BigDecimal aIncome) {
    income = aIncome;
  }

  public Set<BigDecimal> getBills() {
    return bills;
  }

  public void setBills(Set<BigDecimal> aBills) {
    bills = aBills;
  }

  public Set<BigDecimal> getEcpayment() {
    return ecpayment;
  }

  public void setEcpayment(Set<BigDecimal> aEcpayment) {
    ecpayment = aEcpayment;
  }

  public Driver getDriver() {
    return driver;
  }

  public void setDriver(Driver aDriver) {
    driver = aDriver;
  }

  public Store getStore() {
    return store;
  }

  public void setStore(Store aStore) {
    store = aStore;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car aCar) {
    car = aCar;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date aDate) {
    date = aDate;
  }

  public InvoiceType getState() {
    return state;
  }

  public void setState(InvoiceType aState) {
    state = aState;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    Invoice invoice = (Invoice) o;

    if (bills != null ? !bills.equals(invoice.bills) : invoice.bills != null) {
      return false;
    }
    if (car != null ? !car.equals(invoice.car) : invoice.car != null) {
      return false;
    }
    if (date != null ? !date.equals(invoice.date) : invoice.date != null) {
      return false;
    }
    if (driver != null ? !driver.equals(invoice.driver) : invoice.driver != null) {
      return false;
    }
    if (ecpayment != null ? !ecpayment.equals(invoice.ecpayment) : invoice.ecpayment != null) {
      return false;
    }
    if (income != null ? !income.equals(invoice.income) : invoice.income != null) {
      return false;
    }
    if (state != invoice.state) {
      return false;
    }
    if (store != null ? !store.equals(invoice.store) : invoice.store != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (income != null ? income.hashCode() : 0);
    result = 31 * result + (bills != null ? bills.hashCode() : 0);
    result = 31 * result + (ecpayment != null ? ecpayment.hashCode() : 0);
    result = 31 * result + (driver != null ? driver.hashCode() : 0);
    result = 31 * result + (store != null ? store.hashCode() : 0);
    result = 31 * result + (car != null ? car.hashCode() : 0);
    result = 31 * result + (date != null ? date.hashCode() : 0);
    result = 31 * result + (state != null ? state.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Invoice{" +
           "income=" + income +
           ", bills=" + bills +
           ", ecpayment=" + ecpayment +
           ", driver=" + driver +
           ", store=" + store +
           ", car=" + car +
           ", date=" + date +
           ", state=" + state +
           '}';
  }

  /* some buisness logic methods, <b>DO NOT DELETE</b> in order so autogenerate
      getter and setter!
       */
  @Transient
  public BigDecimal getBillAmount() {
    BigDecimal sum = new BigDecimal(0);
    if (bills != null) {
      for (BigDecimal d : bills) {
        sum = sum.add(d);
      }
    }
    return sum;
  }

  @Transient
  public BigDecimal getECAmount() {
    BigDecimal sum = new BigDecimal(0);
    if (ecpayment != null) {
      for (BigDecimal d : ecpayment) {
        sum = sum.add(d);
      }
    }
    return sum;
  }
}
