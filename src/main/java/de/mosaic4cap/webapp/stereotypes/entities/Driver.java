package de.mosaic4cap.webapp.stereotypes.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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

	@Column(name = "firstname", length = 25)
	private String firstName;

	@Column(name = "lastname", length = 25)
	private String lastName;

	@Temporal(TemporalType.DATE)
	private Date birthDay;

	public Driver() {
	}

	public Driver(String pFirstName, String pLastName, Date pBirthDay) {
		firstName = pFirstName;
		lastName = pLastName;
		birthDay = pBirthDay;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String pFirstName) {
		firstName = pFirstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String pLastName) {
		lastName = pLastName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date pBirthDay) {
		birthDay = pBirthDay;
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

		Driver lDriver = (Driver) o;

		if (birthDay != null ? !birthDay.equals(lDriver.birthDay) : lDriver.birthDay != null) {
			return false;
		}
		if (firstName != null ? !firstName.equals(lDriver.firstName) : lDriver.firstName != null) {
			return false;
		}
		if (lastName != null ? !lastName.equals(lDriver.lastName) : lDriver.lastName != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int lresult = super.hashCode();
		lresult = 31 * lresult + (firstName != null ? firstName.hashCode() : 0);
		lresult = 31 * lresult + (lastName != null ? lastName.hashCode() : 0);
		lresult = 31 * lresult + (birthDay != null ? birthDay.hashCode() : 0);
		return lresult;
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
