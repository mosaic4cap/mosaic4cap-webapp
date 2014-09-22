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
 * <p/>
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
 private Map<Long, Invoice> storeaccount;

    /*@ManyToOne(targetEntity = Customer.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@MapKey(name = "id")
    private Map<Long, Customer> customer; */

 public Store() {
 }

 public Store(String pKey,
							Chef pChef,
							Map<Long, Driver> pDriver,
							Map<Long, Car> pCar,
							Map<Long, Invoice> pStoreaccount) {
	key = pKey;
	chef = pChef;
	driver = pDriver;
	car = pCar;
	storeaccount = pStoreaccount;
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

 public Map<Long, Invoice> getStoreaccount() {
	return storeaccount;
 }

 public void setStoreaccount(Map<Long, Invoice> pStoreaccount) {
	storeaccount = pStoreaccount;
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

	Store lStore = (Store) o;

	if (car != null ? !car.equals(lStore.car) : lStore.car != null) {
	 return false;
	}
	if (chef != null ? !chef.equals(lStore.chef) : lStore.chef != null) {
	 return false;
	}
	if (driver != null ? !driver.equals(lStore.driver) : lStore.driver != null) {
	 return false;
	}
	if (key != null ? !key.equals(lStore.key) : lStore.key != null) {
	 return false;
	}
	if (storeaccount != null ? !storeaccount.equals(lStore.storeaccount) : lStore.storeaccount != null) {
	 return false;
	}

	return true;
 }

 @Override
 public int hashCode() {
	int lresult = super.hashCode();
	lresult = 31 * lresult + (key != null ? key.hashCode() : 0);
	lresult = 31 * lresult + (chef != null ? chef.hashCode() : 0);
	lresult = 31 * lresult + (driver != null ? driver.hashCode() : 0);
	lresult = 31 * lresult + (car != null ? car.hashCode() : 0);
	lresult = 31 * lresult + (storeaccount != null ? storeaccount.hashCode() : 0);
	return lresult;
 }

 @Override
 public String toString() {
	return "Store{" +
				 "key='" + key + '\'' +
				 ", chef=" + chef +
				 ", driver=" + driver +
				 ", car=" + car +
				 ", storeaccount=" + storeaccount +
				 '}';
 }
}
