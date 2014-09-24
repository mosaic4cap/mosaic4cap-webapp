package de.mosaic4cap.webapp.stereotypes.entities;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;

/**
 * Created by svenklemmer on 29.08.14.
 * <p>
 * Representing physical store
 */
@Entity
@Table(name = "store")
public class Store extends AbstractMosaicEntity {
	private static final Logger LOGGER = Logger.getLogger(Store.class);

	@Column(name = "store_key", length = 10)
	private String key;

	/**
	 * The Chef this store belongs to
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chef_id")
	private Chef chef;

	@javax.persistence.OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@javax.persistence.MapKey(name = "id")
	private Map<Long, Driver> driver;

	@javax.persistence.OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@javax.persistence.MapKey(name = "id")
	private Map<Long, Car> car;

	@javax.persistence.OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@javax.persistence.MapKey(name = "id")
	private Map<Long, Invoice> invoice;

    /*@ManyToOne(targetEntity = Customer.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@MapKey(name = "id")
    private Map<Long, Customer> customer; */

	public Store() {
	}

	public Store(String aKey,
							 Chef aChef,
							 Map<Long, Driver> aDriver,
							 Map<Long, Car> aCar,
							 Map<Long, Invoice> aInvoice) {
		key = aKey;
		chef = aChef;
		driver = aDriver;
		car = aCar;
		invoice = aInvoice;
	}

	public Map<Long, Driver> getDriver() {
		return driver;
	}

	public void setDriver(Map<Long, Driver> pDriver) {
		driver = pDriver;
	}

	public Map<Long, Car> getCar() {
		return car;
	}

	public void setCar(Map<Long, Car> pCar) {
		car = pCar;
	}

	public Map<Long, Invoice> getInvoice() {
		return invoice;
	}

	public void setInvoice(Map<Long, Invoice> aInvoice) {
		invoice = aInvoice;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String pKey) {
		key = pKey;
	}

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef pChef) {
		chef = pChef;
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

		Store store = (Store) o;

		if (car != null ? !car.equals(store.car) : store.car != null) {
			return false;
		}
		if (chef != null ? !chef.equals(store.chef) : store.chef != null) {
			return false;
		}
		if (driver != null ? !driver.equals(store.driver) : store.driver != null) {
			return false;
		}
		if (invoice != null ? !invoice.equals(store.invoice) : store.invoice != null) {
			return false;
		}
		if (key != null ? !key.equals(store.key) : store.key != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (key != null ? key.hashCode() : 0);
		result = 31 * result + (chef != null ? chef.hashCode() : 0);
		result = 31 * result + (driver != null ? driver.hashCode() : 0);
		result = 31 * result + (car != null ? car.hashCode() : 0);
		result = 31 * result + (invoice != null ? invoice.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Store{" +
					 "key='" + key + '\'' +
					 ", chef=" + chef +
					 ", driver=" + driver +
					 ", car=" + car +
					 ", invoice=" + invoice +
					 '}';
	}
}
