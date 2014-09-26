package de.mosaic4cap.webapp.stereotypes.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.log4j.Logger;

import de.mosaic4cap.webapp.stereotypes.enumeration.StoreType;

/**
 * Created by svenklemmer on 29.08.14.
 * <p>
 * Representing physical store
 */
@Entity
@Table(name = "store")
public class Store extends AbstractMosaic4CapEntity {
	private static final Logger LOGGER = Logger.getLogger(Store.class);

	@Column(name = "store_key")
	private String storeKey;

	@Column(name = "store_type")
	@Enumerated(EnumType.ORDINAL)
	private StoreType storeType;

	@ManyToOne
	@JoinColumn
	private Chef chef;

	@OneToMany(mappedBy = "store")
	private Set<Driver> drivers;

	@OneToMany(mappedBy = "store")
	private Set<Car> cars;

	@OneToMany(mappedBy = "store")
	private Set<Invoice> invoices;

	public Store() {
	}

	public Store(String aStoreKey,
							 StoreType aStoreType,
							 Chef aChef,
							 Set<Driver> aDrivers,
							 Set<Car> aCars,
							 Set<Invoice> aInvoices) {
		storeKey = aStoreKey;
		storeType = aStoreType;
		chef = aChef;
		drivers = aDrivers;
		cars = aCars;
		invoices = aInvoices;
	}

	public String getStoreKey() {

		return storeKey;
	}

	public void setStoreKey(String aStoreKey) {
		storeKey = aStoreKey;
	}

	public StoreType getStoreType() {
		return storeType;
	}

	public void setStoreType(StoreType aStoreType) {
		storeType = aStoreType;
	}

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef aChef) {
		chef = aChef;
	}

	public Set<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(Set<Driver> aDrivers) {
		drivers = aDrivers;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> aCars) {
		cars = aCars;
	}

	public Set<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(Set<Invoice> aInvoices) {
		invoices = aInvoices;
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

		if (cars != null ? !cars.equals(store.cars) : store.cars != null) {
			return false;
		}
		if (chef != null ? !chef.equals(store.chef) : store.chef != null) {
			return false;
		}
		if (drivers != null ? !drivers.equals(store.drivers) : store.drivers != null) {
			return false;
		}
		if (invoices != null ? !invoices.equals(store.invoices) : store.invoices != null) {
			return false;
		}
		if (storeKey != null ? !storeKey.equals(store.storeKey) : store.storeKey != null) {
			return false;
		}
		if (storeType != store.storeType) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (storeKey != null ? storeKey.hashCode() : 0);
		result = 31 * result + (storeType != null ? storeType.hashCode() : 0);
		result = 31 * result + (chef != null ? chef.hashCode() : 0);
		result = 31 * result + (drivers != null ? drivers.hashCode() : 0);
		result = 31 * result + (cars != null ? cars.hashCode() : 0);
		result = 31 * result + (invoices != null ? invoices.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Store{" +
					 "storeKey='" + storeKey + '\'' +
					 ", storeType=" + storeType +
					 ", chef=" + chef +
					 ", drivers=" + drivers +
					 ", cars=" + cars +
					 ", invoices=" + invoices +
					 '}';
	}
}
