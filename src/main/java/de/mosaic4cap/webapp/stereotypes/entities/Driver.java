package de.mosaic4cap.webapp.stereotypes.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.log4j.Logger;

/**
 * Created by Lobedan on 30.08.2014.
 */
@Entity
@Table(name = "driver")
public class Driver extends AbstractMosaic4CapEntity {
	private static final Logger LOGGER = Logger.getLogger(Driver.class);


  @ManyToOne
  @JoinColumn
  private Store store;

	@Column(name = "firstname", length = 25)
	private String firstName;

	@Column(name = "lastname", length = 25)
	private String lastName;

	@Temporal(TemporalType.DATE)
	private Date birthDay;

	public Driver() {
	}

  public Driver(Store aStore, String aFirstName, String aLastName, Date aBirthDay) {
    store = aStore;
    firstName = aFirstName;
    lastName = aLastName;
    birthDay = aBirthDay;
  }

  public Store getStore() {

    return store;
  }

  public void setStore(Store aStore) {
    store = aStore;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String aFirstName) {
    firstName = aFirstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String aLastName) {
    lastName = aLastName;
  }

  public Date getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(Date aBirthDay) {
    birthDay = aBirthDay;
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

    Driver driver = (Driver) o;

    if (birthDay != null ? !birthDay.equals(driver.birthDay) : driver.birthDay != null) {
      return false;
    }
    if (firstName != null ? !firstName.equals(driver.firstName) : driver.firstName != null) {
      return false;
    }
    if (lastName != null ? !lastName.equals(driver.lastName) : driver.lastName != null) {
      return false;
    }

    return true;
  }

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (birthDay != null ? birthDay.hashCode() : 0);
		return result;
	}

	@Override
  public String toString() {
    return "Driver{" +
           "firstName='" + firstName + '\'' +
           ", lastName='" + lastName + '\'' +
           ", birthDay=" + birthDay +
           '}';
  }
}
