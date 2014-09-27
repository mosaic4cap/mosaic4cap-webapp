package de.mosaic4cap.webapp.stereotypes.entities;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;

/**
 * Created by Lobedan on 30.08.2014.
 */
@javax.persistence.Entity
@Table(name = "car")
public class Car extends AbstractMosaic4CapEntity {
	private static final Logger LOGGER = Logger.getLogger(Car.class);

	private String badge;
	private boolean available;

	@ManyToOne(targetEntity = Store.class)
	@JoinColumn
	private Store store;

	public Car() {
	}

	public Car(String aBadge, boolean aAvailable, Store aStore) {
		badge = aBadge;
		available = aAvailable;
		store = aStore;
	}

	public String getBadge() {
		return badge;
	}

	public void setBadge(String aBadge) {
		badge = aBadge;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean aAvailable) {
		available = aAvailable;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store aStore) {
		store = aStore;
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

		Car car = (Car) o;

		if (available != car.available) {
			return false;
		}
		if (badge != null ? !badge.equals(car.badge) : car.badge != null) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (badge != null ? badge.hashCode() : 0);
		result = 31 * result + (available ? 1 : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Car{" +
					 "badge='" + badge + '\'' +
					 ", available=" + available +
					 '}';
	}
}
