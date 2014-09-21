package de.mosaic4cap.webapp.stereotypes.domain;

import org.apache.log4j.Logger;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Lobedan on 30.08.2014.
 */
@Entity
@Table(name = "car")
public class Car extends AbstractMosaicEntity {
  private static final Logger LOGGER = Logger.getLogger(Car.class);

  private String badge;
  private boolean available;

  public Car() {
  }

  public Car(String pBadge, boolean pAvailable) {
    badge = pBadge;
    available = pAvailable;
  }

  public String getBadge() {
    return badge;
  }

  public void setBadge(String pBadge) {
    badge = pBadge;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean pAvailable) {
    available = pAvailable;
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

    Car lCar = (Car) o;

    if (available != lCar.available) {
      return false;
    }
    if (badge != null ? !badge.equals(lCar.badge) : lCar.badge != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int lresult = super.hashCode();
    lresult = 31 * lresult + (badge != null ? badge.hashCode() : 0);
    lresult = 31 * lresult + (available ? 1 : 0);
    return lresult;
  }

  @Override
  public String toString() {
    return "Car{" +
           "badge='" + badge + '\'' +
           ", available=" + available +
           '}';
  }
}
