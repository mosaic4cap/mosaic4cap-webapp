package de.mosaic4cap.webapp.stereotypes.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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

	@ElementCollection(fetch = FetchType.EAGER)
	private List<BigDecimal> bills;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<BigDecimal> ecpayment;

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

	public Invoice(BigDecimal pIncome,
								 List<BigDecimal> pBills,
								 List<BigDecimal> pEcpayment,
								 Driver pDriver,
								 Store pStore,
								 Car pCar,
								 Date pDate) {
		income = pIncome;
		bills = pBills;
		ecpayment = pEcpayment;
		driver = pDriver;
		store = pStore;
		car = pCar;
		date = pDate;
		setState(InvoiceType.OPEN);
	}

	public InvoiceType getState() {
		return state;
	}

	public void setState(InvoiceType aState) {
		state = aState;
	}

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

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal pIncome) {
		income = pIncome;
	}

	public List<BigDecimal> getBills() {
		return bills;
	}

	public void setBills(List<BigDecimal> pBills) {
		bills = pBills;
	}

	public List<BigDecimal> getEcpayment() {
		return ecpayment;
	}

	public void setEcpayment(List<BigDecimal> pEcpayment) {
		ecpayment = pEcpayment;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver pDriver) {
		driver = pDriver;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store pStore) {
		store = pStore;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car pCar) {
		car = pCar;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date pDate) {
		date = pDate;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Invoice that = (Invoice) o;

		if (bills != null ? !bills.equals(that.bills) : that.bills != null) {
			return false;
		}
		if (car != null ? !car.equals(that.car) : that.car != null) {
			return false;
		}
		if (date != null ? !date.equals(that.date) : that.date != null) {
			return false;
		}
		if (driver != null ? !driver.equals(that.driver) : that.driver != null) {
			return false;
		}
		if (ecpayment != null ? !ecpayment.equals(that.ecpayment) : that.ecpayment != null) {
			return false;
		}
		if (income != null ? !income.equals(that.income) : that.income != null) {
			return false;
		}
		if (store != null ? !store.equals(that.store) : that.store != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int lresult = income != null ? income.hashCode() : 0;
		lresult = 31 * lresult + (bills != null ? bills.hashCode() : 0);
		lresult = 31 * lresult + (ecpayment != null ? ecpayment.hashCode() : 0);
		lresult = 31 * lresult + (driver != null ? driver.hashCode() : 0);
		lresult = 31 * lresult + (store != null ? store.hashCode() : 0);
		lresult = 31 * lresult + (car != null ? car.hashCode() : 0);
		lresult = 31 * lresult + (date != null ? date.hashCode() : 0);
		return lresult;
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
}
