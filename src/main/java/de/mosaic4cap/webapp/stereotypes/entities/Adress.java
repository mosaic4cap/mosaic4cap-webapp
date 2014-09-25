package de.mosaic4cap.webapp.stereotypes.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.log4j.Logger;

/**
 * Created by Lobedan on 03.09.2014.
 */
@Entity
@Table(name = "adress")
public class Adress extends AbstractMosaic4CapEntity {
	private static final Logger LOGGER = Logger.getLogger(Adress.class);

	private String street;
	private String number;
	private String zip;
	private String city;

	public Adress() {
	}

	public Adress(String pStreet, String pNumber, String pZip, String pCity) {

		street = pStreet;
		number = pNumber;
		zip = pZip;
		city = pCity;
	}

	public String getCity() {

		return city;
	}

	public void setCity(String pCity) {
		city = pCity;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String pZip) {
		zip = pZip;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String pNumber) {
		number = pNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String pStreet) {
		street = pStreet;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Adress lAdress = (Adress) o;

		if (city != null ? !city.equals(lAdress.city) : lAdress.city != null) {
			return false;
		}
		if (number != null ? !number.equals(lAdress.number) : lAdress.number != null) {
			return false;
		}
		if (street != null ? !street.equals(lAdress.street) : lAdress.street != null) {
			return false;
		}
		if (zip != null ? !zip.equals(lAdress.zip) : lAdress.zip != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int lresult = street != null ? street.hashCode() : 0;
		lresult = 31 * lresult + (number != null ? number.hashCode() : 0);
		lresult = 31 * lresult + (zip != null ? zip.hashCode() : 0);
		lresult = 31 * lresult + (city != null ? city.hashCode() : 0);
		return lresult;
	}

	@Override
	public String toString() {
		return "Adress{" +
					 "city='" + city + '\'' +
					 ", zip='" + zip + '\'' +
					 ", number='" + number + '\'' +
					 ", street='" + street + '\'' +
					 '}';
	}
}
